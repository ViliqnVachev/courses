package database;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {


        Database database = new Database(null);
        database.add(16);
        System.out.println(database.removeNumber());
        // database.add(15);


        System.out.println(database.fetch().length);
    }
}
