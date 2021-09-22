package list_iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator<String> listIterator;

    @Before
    public void init() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>("Gosho", "Pesho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParameters() throws OperationNotSupportedException {
        // Arrange
        ListIterator<String> temp = new ListIterator<>("Ivan",null);
    }

    @Test
    public void hasNext() {
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void move() {
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void print() {
        // Act
        this.listIterator.move();
        String actualElement = this.listIterator.print();
        String expectElement = "Pesho";

        // Assert
        Assert.assertEquals(expectElement, actualElement);
    }

    @Test(expected = NullPointerException.class)
    public void printEmptyCollection() throws OperationNotSupportedException {
        // Arrange
        ListIterator<String> temp = new ListIterator<>();

        // Act
        String actualElement = temp.print();

        // Assert

    }
}