package jar_of_T;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(T element) {
        this.stack.push(element);
    }

    public T remove() {
        if (this.stack.isEmpty()) {
            throw new IllegalArgumentException("The jar is empty!");
        }
        return this.stack.pop();
    }
}
