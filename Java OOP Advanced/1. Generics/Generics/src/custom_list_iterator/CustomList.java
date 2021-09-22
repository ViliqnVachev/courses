package custom_list_iterator;

import java.util.List;

public interface CustomList<T extends Comparable<T>> {

    void sort();

    List<T> getItems();

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int firstIndex, int secondIndex);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

}
