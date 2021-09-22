package stack_of_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (!this.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
    }

    public String peek() {
        if (!this.isEmpty()) {
            return this.data.get(this.data.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
