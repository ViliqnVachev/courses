package extended_database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.omg.PortableServer.POA;

import javax.naming.OperationNotSupportedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private People person;

    @Before
    public void init() throws OperationNotSupportedException {
        this.database = new Database();
        this.person = Mockito.mock(People.class);
        Mockito.when(this.person.getId()).thenReturn(16L);
        Mockito.when(this.person.getUsername()).thenReturn("Test");
        this.database.add(person);
    }


    @Test
    public void add() throws OperationNotSupportedException {
        // Arrange
        People p1 = Mockito.mock(People.class);
        Mockito.when(p1.getId()).thenReturn(15L);
        Mockito.when(p1.getUsername()).thenReturn("Test");

        // Act
        this.database.add(p1);
        int actualSize = this.database.getPeople().length;
        int expectedSize = 2;

        // Assert
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addInvalidIDPeople() throws OperationNotSupportedException {
        // Arrange

        Mockito.when(this.person.getId()).thenReturn(-5L);
        Mockito.when(this.person.getUsername()).thenReturn("Test");

        // Act
        this.database.add(this.person);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPeopleWithEqualsIDs() throws OperationNotSupportedException {
        // Arrange
        Database database = new Database();

        People p1 = Mockito.mock(People.class);
        People p2 = Mockito.mock(People.class);
        Mockito.when(p1.getUsername()).thenReturn("Test");
        Mockito.when(p2.getUsername()).thenReturn("Test");
        Mockito.when(p1.getId()).thenReturn(15L);
        Mockito.when(p2.getId()).thenReturn(15L);

        // Act
        this.database.add(p1);
        this.database.add(p2);

    }

    @Test
    public void removePeople() throws OperationNotSupportedException {

        // Act
        People people = this.database.remove();

        // Assert
        Assert.assertEquals(people, this.person);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void removePeopleFromEmptyDB() throws OperationNotSupportedException {

        // Act
        People people = this.database.remove();
        People people1 = this.database.remove();

        // Assert
        Assert.assertEquals(people, this.person);

    }

    @Test
    public void findByID() throws OperationNotSupportedException {
        //Act

        People people = this.database.findByID(16);

        //Assert
        Assert.assertEquals(people, this.person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByInvalidID() throws OperationNotSupportedException {
        //Act

        People people = this.database.findByID(15);


    }

    @Test
    public void findByUserName() throws OperationNotSupportedException {
        //Act

        People people = this.database.findByUserName("Test");

        //Assert
        Assert.assertEquals(people, this.person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByInvalidUserName() throws OperationNotSupportedException {
        //Act

        People people = this.database.findByUserName(null);
    }

    @Test
    public void returnPeopleArray() {
        People[] people = this.database.getPeople();

        assertEquals(people.length,this.database.getPeople().length);
    }
}