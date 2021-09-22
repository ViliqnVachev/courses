package extended_database;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        Database database = new Database();

        People people = new People("Test", 5L);
        People people2 = new People("Test", 6L);
        database.add(people);
        database.add(people2);

        People people1 = database.findByID(5);
        System.out.println(people1);

    }
}
