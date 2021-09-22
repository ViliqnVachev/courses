package custom_list;

import java.util.ArrayList;
import java.util.List;

public class MyCustomList<T extends Comparable<T>> implements CustomList<T> {
    private List<T> items;

    public MyCustomList() {
        this.items = new ArrayList<>();
    }

    @Override
    public Iterable<T> getItems() {
        return items;
    }

    @Override
    public void add(T element) {
        this.items.add(element);
    }

    @Override
    public T remove(int index) {
        return this.items.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.items.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        T temp = this.items.get(firstIndex);
        this.items.set(firstIndex, this.items.get(secondIndex));
        this.items.set(secondIndex, temp);
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (T item : items) {
            if (element.compareTo(item) < 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        T maxItem = this.items.get(0);
        for (T item : items) {
            if (maxItem.compareTo(item) < 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }

    @Override
    public T getMin() {
        T minItem = this.items.get(0);
        for (T item : items) {
            if (minItem.compareTo(item) > 0) {
                minItem = item;
            }
        }
        return minItem;
    }


}
