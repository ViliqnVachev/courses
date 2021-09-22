package listyIterator;

import java.util.Arrays;

public class ListyIterator<T> {
    private T[] items;
    private int index;

    public ListyIterator(T... items) {
        this.items = items;
        this.index = 0;
    }

    public boolean hasNext() {
        if (this.index < this.items.length-1) {
            return true;
        }
        return false;
    }

    public boolean move() {
        if (this.hasNext() && this.items.length > 0) {
            this.index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.index > this.items.length || this.items.length == 0 || this.items.length - 1 < this.index) {
            throw new IllegalArgumentException("Invalid Operation!");
        } else {
            System.out.println(this.items[index]);
        }
    }
}
