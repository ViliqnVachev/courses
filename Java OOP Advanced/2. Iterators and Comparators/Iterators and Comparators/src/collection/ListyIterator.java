package collection;

import java.util.Iterator;

public class ListyIterator<T> implements Iterable<T> {
    private T[] items;
    private int index;

    public ListyIterator(T... items) {
        this.items = items;
        this.index = 0;
    }

    public boolean hasNext() {
        if (this.index < this.items.length - 1) {
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

    public String printAll() {
        StringBuilder sb = new StringBuilder();

        for (T t : this) {
            sb.append(t).append(" ");
        }

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<T> {
        private int count;

        public ListIterator() {
            this.count = 0;
        }

        @Override
        public boolean hasNext() {
            return this.count < items.length;
        }

        @Override
        public T next() {
            return items[count++];
        }
    }
}
