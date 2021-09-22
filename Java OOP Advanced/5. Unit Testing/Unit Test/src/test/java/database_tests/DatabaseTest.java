package database_tests;

import database.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        this.database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

    @Test
    public void testDatabaseConstructor() {
        // Arrange


        // Act
        int actualSize = this.database.fetch().length;
        int expectSize = 15;

        //Assert

        Assert.assertEquals(expectSize, actualSize);
    }

    @Test
    public void addElement() throws OperationNotSupportedException {
        // Arrange

        //Act
        this.database.add(5);
        int actualSize = this.database.fetch().length;
        int expectSize = 16;

        //Assert
        Assert.assertEquals(expectSize, actualSize);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNullElementException() throws OperationNotSupportedException {
        // Arrange

        //Act
        this.database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addElementMoreThan16Exception() throws OperationNotSupportedException {
        // Arrange

        //Act
        this.database.add(16);
        this.database.add(17);
    }

    @Test
    public void removeLastElement() throws OperationNotSupportedException {
        //Arrange

        //Act
        Integer actualElement = this.database.removeNumber();
        Integer expectedElement = 15;

        //Assert
        Assert.assertEquals(expectedElement, actualElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeElementFromEmptyDB() throws OperationNotSupportedException {
        //Arrange
        Database database = new Database();
        //Act
        database.removeNumber();
    }

    @Test
    public void getFetch(){
        // Arrange

        // Act
        Integer[] fetch = this.database.fetch();

        // Assert
        Assert.assertEquals(fetch.length,this.database.fetch().length);
    }
}
