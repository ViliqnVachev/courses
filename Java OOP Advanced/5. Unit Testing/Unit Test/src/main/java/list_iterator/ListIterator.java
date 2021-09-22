package list_iterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIterator<T> {

    private int tempIndex;
    private List<T> elements;

    public ListIterator(T... elements) throws OperationNotSupportedException {
        this.setElements(elements);
        this.tempIndex = 0;
    }

    private void setElements(T... elements) throws OperationNotSupportedException {
        for (T element : elements) {
            if (element == null) {
                throw new OperationNotSupportedException("Invalid Operation");
            }
        }
        this.elements = new ArrayList<T>(Arrays.asList(elements));


    }

    public boolean hasNext() {
        return this.tempIndex < this.elements.size() - 1;
    }

    public boolean move() {
        if (this.tempIndex < this.elements.size()) {
            this.tempIndex++;
            return true;
        }
        return false;
    }

    public T print() {
        if (this.elements.isEmpty()) {
            throw new NullPointerException("Invalid Operation!");
        }

        return this.elements.get(this.tempIndex);
    }

}
