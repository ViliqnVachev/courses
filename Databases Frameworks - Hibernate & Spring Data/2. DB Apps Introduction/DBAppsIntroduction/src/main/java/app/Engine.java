package app;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {
    private Connection connection;

    public Engine(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            this.increaseMinionsAge();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    /*
     * Problem 2 Get Villains' Names
     * */
    private void getVillainsNames() throws SQLException {
        String query = "SELECT v.name, count(vm.minion_id) FROM villains v join minions_villains vm on v.id = vm.villain_id GROUP BY  v.id HAVING count(vm.minion_id)>? ORDER BY count(vm.minion_id) DESC;";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        preparedStatement.setInt(1, 15);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(String.format("%s %d", resultSet.getString("name"), resultSet.getInt(2)));

        }
    }

    /*
     * Problem  3.	Get Minion Names
     * */
    private void getMinionsNames() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String query = "SELECT v.name, m.name, m.age FROM minions m JOIN minions_villains vm ON m.id = vm.minion_id JOIN villains v on vm.villain_id = v.id WHERE vm.villain_id=? GROUP BY m.name";

        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        preparedStatement.setInt(1, Integer.parseInt(reader.readLine()));

        ResultSet resultSet = preparedStatement.executeQuery();

        int index = 1;
        resultSet.next();
        System.out.println("Villain: " + resultSet.getString(1));
        System.out.println(String.format("%d. %s %d", index++, resultSet.getString(2), resultSet.getInt(3)));
        while (resultSet.next()) {
            System.out.println(String.format("%d. %s %d", index++, resultSet.getString(2), resultSet.getInt(3)));
        }
    }

    /*
     * Problem 4. Add Minion
     */
    private void addMinion() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionParams = reader.readLine().split("\\s+");
        String[] villainParams = reader.readLine().split("\\s+");

        String minionName = minionParams[1];
        int minionAge = Integer.parseInt(minionParams[2]);
        String minionTown = minionParams[3];

        String villainName = villainParams[1];

        if (!this.checkIfEntityExist(minionTown, "towns")) {
            this.insertTown(minionTown);
        }

        if (!this.checkIfEntityExist(villainName, "villains")) {
            this.insertVillain(villainName);
        }

        int townId = this.getEntityId(minionTown, "towns");
        this.insertMinion(minionName, minionAge, townId);

        System.out.println(String.format("Successfully added %s to be minion of %s.", minionName, villainName));

        int villainId = this.getEntityId(villainName, "villains");
        int minionId = this.getEntityId(minionName, "minions");

        this.insertMinionVillain(minionId, villainId);
    }


    private boolean checkIfEntityExist(String name, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE name=?";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();


        return resultSet.next();
    }

    private void insertTown(String townName) throws SQLException {
        String query = "INSERT INTO towns (name, country) VALUES('" + townName + "',NULL )";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        preparedStatement.execute();
        System.out.println(String.format("Town %s was added to the database.", townName));
    }


    private void insertVillain(String villainName) throws SQLException {
        String query = String.format("INSERT INTO villains (name, evilness_factor) VALUES('%s', 'evil' )", villainName);
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        preparedStatement.execute();
        System.out.println(String.format("Villain %s was added to the database.", villainName));
    }

    private int getEntityId(String name, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name= '%s'", tableName, name);
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        return resultSet.getInt(1);
    }

    private void insertMinion(String minionName, int age, int townId) throws SQLException {
        String query = String.format("INSERT INTO minions (name, age, town_id) VALUES('%s', '%d', '%d')", minionName, age, townId);

        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);
        preparedStatement.execute();

    }

    private void insertMinionVillain(int minionId, int villainId) throws SQLException {
        String query = String.format("INSERT INTO minions_villains (minion_id, villain_id) VALUES(%d,%d)", minionId, villainId);
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        preparedStatement.execute();
    }

    /*
     * Problem 5. Change Town Names Casing
     * */
    private void changeTownNamesCasing() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country = reader.readLine();

        if (!this.checkIfEntityExist(country, "towns")) {
            List<String> towns = this.getEntityData(country, "towns");
            if (towns.isEmpty()) {
                System.out.println("No town names were affected.");
                return;
            }
            this.chaneTownsCasing(towns);

            towns.replaceAll(String::toUpperCase);

            System.out.println(towns.size() + " town names were affected.");
            StringBuilder sb = new StringBuilder();
            sb.append(String.join(", ", towns));
            System.out.println(String.format("[%s]", sb.toString()));
        }


    }

    private List<String> getEntityData(String param, String tableName) throws SQLException {
        List<String> towns = new ArrayList<String>();
        String query = "SELECT * FROM " + tableName + " WHERE country=?";

        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        preparedStatement.setString(1, param);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            towns.add(resultSet.getString(2));
        }
        return towns;
    }

    private void chaneTownsCasing(List<String> towns) throws SQLException {
        String query = "UPDATE towns SET name=? WHERE name=?";
        for (int i = 0; i < towns.size(); i++) {
            PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

            preparedStatement.setString(1, towns.get(i).toUpperCase());
            preparedStatement.setString(2, towns.get(i));

            preparedStatement.execute();
        }
    }

    /*
     * Problem 7. Print All Minion Names
     * */
    private void printAllMinionsNames() throws SQLException {

        List<String> minions = this.getMinionsData();

        for (int i = 0; i < minions.size() / 2; i++) {
            System.out.println(minions.get(i));
            System.out.println(minions.get(minions.size() - 1 - i));
        }
        System.out.println();

    }

    //Change for problem 8
    private List<String> getMinionsData() throws SQLException {
        List<String> minions = new ArrayList<>();

        String query = "SELECT * FROM minions";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String minionInfo = resultSet.getString("name") + " " + resultSet.getString("age");
            minions.add(minionInfo);
        }
        return minions;
    }

    /*
     * Problem 8. Increase Minions Age
     * */

    private void increaseMinionsAge() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] minionsId = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        this.updateMinionsAge(minionsId);
        List<String> minionsData = this.getMinionsData();

        minionsData.forEach(System.out::println);

    }

    private void updateMinionsAge(int[] minionsId) throws SQLException {
        String query = "UPDATE minions set age=age+1 WHERE id =?";

        for (int i = 0; i < minionsId.length; i++) {
            PreparedStatement preparedStatement = this.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, minionsId[i]);
            preparedStatement.execute();
        }

    }
}
