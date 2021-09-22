package stack_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyStack<T> implements Iterable<T> {
    private List<T> stack;

    public MyStack() {
        this.stack = new ArrayList<>();
    }

    public void push(T... element) {
        this.stack.addAll(Arrays.asList(element));
    }

    public T pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalArgumentException("No elements");
        }
        return this.stack.remove(this.stack.size() - 1);
    }

    public T peek() {
        return this.stack.get((this.stack.size() - 1));
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {
        private int index;

        public StackIterator() {
            this.index = stack.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public T next() {
            return stack.get(index--);
        }
    }
}
