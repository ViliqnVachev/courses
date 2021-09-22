package stack_iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomStack<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 16;

    private T[] items;
    private int size;

    public CustomStack() {
        this.items = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void grow() {
        this.items = Arrays.copyOf(this.items, this.items.length * 2);
    }

    public void push(T element) {
        if (this.items.length == this.size) {
            this.grow();
        }
        this.items[this.size++] = element;
    }

    public T pop() {
        if (this.size == 0) {
            throw new NoSuchElementException("No elements");
        }
        T element = this.items[--this.size];
        this.items[this.size] = null;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {
        private int index = size - 1;

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public T next() {
            return items[index--];
        }
    }
}
