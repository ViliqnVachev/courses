package com.viliqn.db;

import com.viliqn.db.anotation.Column;
import com.viliqn.db.anotation.Entity;
import com.viliqn.db.anotation.PrimaryKey;
import com.viliqn.db.contracts.DbContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityDbContext<T> implements DbContext<T> {
    private static final String SELECT_QUERY_TEMPLATE = "SELECT * FROM {0}";
    private static final String SELECT_WHERE_QUERY_TEMPLATE = "SELECT * FROM {0} WHERE {1}";
    private static final String SELECT_SINGLE_QUERY_TEMPLATE = "SELECT * FROM {0} LIMIT 1";
    private static final String SELECT_SINGLE_WHERE_QUERY_TEMPLATE = "SELECT * FROM {0} WHERE {1} LIMIT 1";
    private static final String WHERE_PRIMARY_KEY = " {0}={1} ";
    private static final String INSERT_QUERY_TEMPLATE = "INSERT INTO {0}({1}) VALUES({2})";
    private static final String SET_QUERY_TEMPLATE = "{0}={1}";
    private static final String UPDATE_QUERY_TEMPLATE = "UPDATE {0} SET {1} WHERE {2}={3}";
    private static final String SELECT_TABLE_EXIST = "SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = '%s';";

    private final Connection connection;
    private final Class<T> klass;

    public EntityDbContext(Connection connection, Class<T> klass) throws SQLException {
        this.connection = connection;
        this.klass = klass;

        if (checksIfTableExists()) {
            updateTable();
        } else {
            createTable();
        }
    }




    public Connection getConnection() {
        return connection;
    }

    public Class<T> getKlass() {
        return klass;
    }


    public boolean persist(T entity) throws IllegalAccessException, SQLException {
        Field primaryKey = getPrimaryKeyField();
        primaryKey.setAccessible(true);

        long primaryKeyValue = (long) primaryKey.get(entity);

        if (primaryKeyValue > 0) {
            return update(entity);
        }

        return insert(entity);

    }



    public List<T> find() throws SQLException, IllegalAccessException, InstantiationException {
        return find(null);
    }

    public T findFirst() throws SQLException, IllegalAccessException, InstantiationException {
        return find(SELECT_SINGLE_QUERY_TEMPLATE, null)
                .get(0);

    }

    public List<T> find(String where) throws SQLException, IllegalAccessException, InstantiationException {
        String queryTemplate = where == null
                ? SELECT_QUERY_TEMPLATE
                : SELECT_WHERE_QUERY_TEMPLATE;
        return find(queryTemplate, where);
    }

    public T findFirst(String where) throws SQLException, IllegalAccessException, InstantiationException {
        return find(SELECT_SINGLE_WHERE_QUERY_TEMPLATE, where)
                .get(0);
    }

    public T findById(long id) throws IllegalAccessException, SQLException, InstantiationException {
        String primaryKeyName =
                getPrimaryKeyField().getAnnotation(PrimaryKey.class)
                        .name();

        // {0}={1} -> id=4
        String whereString = MessageFormat.format(
                WHERE_PRIMARY_KEY,
                primaryKeyName,
                id
        );
        return findFirst(whereString);
    }

    public boolean delete(String where) throws SQLException {
        String query = String.format(
                "DELETE FROM %s WHERE %s",
                this.getTableName(),
                where
        );
        PreparedStatement preparedStatement = this.connection.prepareStatement(query);
        return preparedStatement.execute();
    }

    private List<T> find(String template, String where) throws SQLException, IllegalAccessException, InstantiationException {
        String queryString = MessageFormat.format(template, getTableName(), where);
        PreparedStatement preparedStatement = connection.prepareStatement(queryString);
        ResultSet resultSet = preparedStatement.executeQuery();
        return toList(resultSet);
    }

    private List<T> toList(ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();

        while (resultSet.next()) {
            T entity = this.createEntity(resultSet);
            result.add(entity);
        }
        return result;
    }

    private T createEntity(ResultSet resultSet) throws IllegalAccessException, InstantiationException, SQLException {
        T entity = klass.newInstance();
        List<Field> columnNames = getColumns();

        Field primaryKey = getPrimaryKeyField();
        primaryKey.setAccessible(true);
        String primaryKeyColumnName = primaryKey.getAnnotation(PrimaryKey.class)
                .name();
        long primaryKeyValue = resultSet.getLong(primaryKeyColumnName);
        primaryKey.set(entity, primaryKeyValue);

        columnNames.forEach(field -> {
            String columnName = field.getAnnotation(Column.class).name();

            field.setAccessible(true);
            try {
                if (field.getType() == Long.class || field.getType() == long.class) {
                    long value = resultSet.getLong(columnName);
                    field.set(entity, value);
                } else if (field.getType() == String.class) {
                    String value = resultSet.getString(columnName);
                    field.set(entity, value);
                }
            } catch (SQLException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return entity;
    }

    private List<Field> getColumns() {
        return Arrays.stream(klass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());
    }

    private Field getPrimaryKeyField() {
        return Arrays.stream(klass.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Class" + klass + "does not have a primary key annotation"));
    }

    private String getTableName() {
        Annotation annotation = Arrays.stream(klass.getAnnotations())
                .filter(a -> a.annotationType() == Entity.class)
                .findFirst()
                .orElse(null);

        if (annotation == null) {
            return klass.getSimpleName().toLowerCase() + "s";
        }
        return klass.getAnnotation(Entity.class).name();
    }

    private boolean checksIfTableExists() throws SQLException {
        String query = String.format(SELECT_TABLE_EXIST, getTableName());
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    private void createTable() throws SQLException {
//        CREATE TABLE minions(
//        id INT PRIMARY KEY AUTO_INCREMENT,
//        ame VARCHAR(30),
//        age INT,
//        town_id INT
//        );
        String primaryKeyName = getPrimaryKeyField().getDeclaredAnnotation(PrimaryKey.class).name();
        String primaryKeyType = columnsType(getPrimaryKeyField());
        String primaryKey = String.format("%s %s PRIMARY KEY AUTO_INCREMENT", primaryKeyName, primaryKeyType);

        List<Field> columnsFields = getColumns();
        List<String> columnsParams = new ArrayList<>();

        columnsFields.forEach(f -> {
            f.setAccessible(true);
            String nameColumn = f.getAnnotation(Column.class).name();
            String typeColumn = columnsType(f);
            String column = String.format("%s %s", nameColumn, typeColumn);
            columnsParams.add(column);
        });

        String createStatementBody = String.format("%s, %s", primaryKey, String.join(", ", columnsParams));
        String query = String.format("CREATE TABLE %s(%s)", this.getTableName(), createStatementBody);

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private String columnsType(Field field) {
        field.setAccessible(true);

        if (field.getType() == long.class || field.getType() == Long.class) {
            return "INT";
        } else if (field.getType() == String.class) {
            return "VARCHAR(255)";
        }
        return null;
    }

    private List<String> getDatabaseTableColumnsNames() throws SQLException {
        String query = String
                .format(
                        "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = '%s'",
                        this.getTableName()
                );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> columnsNames = new ArrayList<>();

        while (resultSet.next()) {
            columnsNames.add(resultSet.getString(1));
        }

        return columnsNames;
    }

    private void updateTable() throws SQLException {
        List<String> entityColumnsNames = getColumns()
                .stream()
                .map(field -> {
                    return field.getDeclaredAnnotation(Column.class).name();
                })
                .collect(Collectors.toList());
        entityColumnsNames.add(this.getPrimaryKeyField().getDeclaredAnnotation(PrimaryKey.class).name());

        List<String> databaseTableColumnsNames = getDatabaseTableColumnsNames();

        List<String> newColumnsNames = entityColumnsNames
                .stream()
                .filter(columnName -> !databaseTableColumnsNames.contains(columnName))
                .collect(Collectors.toList());

        List<Field> newFields = getColumns()
                .stream()
                .filter(field -> {
                    return newColumnsNames.contains(field.getDeclaredAnnotation(Column.class).name());
                })
                .collect(Collectors.toList());

        List<String> columnsDefinitions = new ArrayList<>();

        newFields.forEach(field -> {
            String columnDefinition = String
                    .format(
                            "ADD COLUMN %s %s",
                            field.getDeclaredAnnotation(Column.class).name(),
                            columnsType(field)
                    );

            columnsDefinitions.add(columnDefinition);
        });

        String queryBody = String.join(", ", columnsDefinitions);

        String query = String
                .format(
                        "ALTER TABLE %s %s",
                        this.getTableName(),
                        queryBody
                );

        PreparedStatement preparedStatement = this.connection.prepareStatement(query);

        preparedStatement.execute();
    }

    private boolean update(T entity) throws IllegalAccessException, SQLException {

        List<String> updateQueries =
                getColumns().stream()
                        .map(field -> {
                            field.setAccessible(true);
                            try {
                                String columnName = field.getAnnotation(Column.class)
                                        .name();
                                Object value = field.get(entity);
                                if (value instanceof String) {
                                    value = "\'" + value + "\'";
                                }

                                return MessageFormat.format(
                                        SET_QUERY_TEMPLATE,
                                        columnName,
                                        value
                                );
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            return null;
                        })
                        .collect(Collectors.toList());

        String updateQueriesString = String.join(", ", updateQueries);

        Field primaryKey = getPrimaryKeyField();
        primaryKey.setAccessible(true);
        String primaryKeyName =
                primaryKey.getAnnotation(PrimaryKey.class)
                        .name();

        long primaryKeyValue =
                (long) primaryKey
                        .get(entity);

        String queryString = MessageFormat.format(
                UPDATE_QUERY_TEMPLATE,
                getTableName(),
                updateQueriesString,
                primaryKeyName,
                primaryKeyValue
        );

        return connection.prepareStatement(queryString)
                .execute();
    }

    private boolean insert(T entity) throws SQLException {
        List<String> columnNames = new ArrayList<>();
        List<Object> values = new ArrayList<>();

        getColumns().forEach(f -> {
            try {
                f.setAccessible(true);
                String columnName = f.getAnnotation(Column.class).name();
                Object value = f.get(entity);

                columnNames.add(columnName);
                values.add(value);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        String columns = String.join(", ", columnNames);
        String valuesString = values.stream().map(value -> {
            if (value instanceof String) {
                return "\'" + value + "\'";
            }
            return value;
        }).map(o -> {
            if (o == null) {
                return "NULL";
            } else {
                return o.toString();
            }
        }).collect(Collectors.joining(", "));

        String queryString = MessageFormat.format(
                INSERT_QUERY_TEMPLATE,
                getTableName(),
                columns,
                valuesString
        );

        return connection.prepareStatement(queryString)
                .execute();
    }
}
