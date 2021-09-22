package extended_database;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private static final int MAX_CAPACITY = 16;

    private List<People> people;


    public Database(People... args) throws OperationNotSupportedException {
        this.setPeople(args);
    }

    private void setPeople(People... people) throws OperationNotSupportedException {
        if (people.length > MAX_CAPACITY) {
            throw new OperationNotSupportedException("The length is more than 16");
        } else if (isContainsNull(people)) {
            throw new OperationNotSupportedException();
        }
        this.people = new ArrayList<People>(Arrays.asList(people));
    }

    private boolean isContainsNull(People... args) {
        for (People arg : args) {
            if (arg == null) {
                return true;
            }
        }
        return false;
    }

    public void add(People element) throws OperationNotSupportedException {
        if (this.people.size() >= MAX_CAPACITY) {
            throw new OperationNotSupportedException("The length is more than 16");
        } else if (!this.isPeopleValid(element)) {
            throw new OperationNotSupportedException("Invalid People or ID");
        } else if (!this.isValidID(element)){
            throw new OperationNotSupportedException("Invalid People or ID");
        }
            this.people.add(element);
    }

    private boolean isValidID(People element) {
        return element.getId() >= 0;
    }

    private boolean isPeopleValid(People element) {


        for (People person : people) {
            if (element.getId() == person.getId()) {
                return false;
            }
        }


        return true;
    }

    public People remove() throws OperationNotSupportedException {
        if (this.people.size() <= 0) {
            throw new OperationNotSupportedException("The database is empty");
        }
        People people=this.people.remove(this.people.size() - 1);
        return people ;
    }


    public People findByID(long id) throws OperationNotSupportedException {

        for (People person : people) {
            if (person.getId() == id) {
                return person;
            }
        }

        throw new OperationNotSupportedException();
    }

    public People findByUserName(String userName) throws OperationNotSupportedException {
        if (userName == null) {
            throw new OperationNotSupportedException();
        }
        for (People person : people) {
            if (person.getUsername().equals(userName)) {
                return person;
            }
        }
        throw new OperationNotSupportedException();

    }


    public People[] getPeople() {
        People[] people = new People[this.people.size()];
        return this.people.toArray(people);
    }



}
