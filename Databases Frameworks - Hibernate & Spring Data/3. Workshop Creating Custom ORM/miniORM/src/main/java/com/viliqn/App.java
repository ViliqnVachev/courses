package com.viliqn;


import com.viliqn.db.EntityDbContext;
import com.viliqn.db.contracts.DbContext;
import com.viliqn.entities.Minions;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App {
    private static final String STRING_CONNECTION = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "*****";

    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {


        Connection connection = getConnection();
        DbContext<Minions> minionsDbContext = getDbContext(connection, Minions.class);

        Minions minions = new Minions();
        minions.setName("Viliqn");
        minions.setAge(15);
        minions.setTownId(13);
        minions.setName("VT");

        minionsDbContext.delete("id=1");
        minionsDbContext.find().forEach(System.out::println);
        connection.close();
    }

    private static <T> EntityDbContext<T> getDbContext(Connection connection, Class<T> klass) throws SQLException {
        return new EntityDbContext<>(connection, klass);
    }

    private static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(STRING_CONNECTION, properties);
    }
}
