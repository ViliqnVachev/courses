package generic_count_method_double;

import java.util.List;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T item;


    public Box(T item) {
        this.item = item;
    }

    public static <T> List<T> swap(int index1, int index2, List<T> list) {
        T first = list.get(index1);
        T second = list.get(index2);
        list.remove(index1);

        list.add(index1, second);
        list.remove(index2);
        list.add(index2, first);
        return list;
    }

    public static <T extends Comparable<T>> int getBiggerElementCount(List<Box<T>> list, Box<T> element) {
        int count = 0;
        for (Box<T> tBox : list) {
            if (element.compareTo(tBox) < 0) {
                count++;

            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s: %s", this.item.getClass().getName(), this.item));

        return sb.toString();
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.item.compareTo(other.item);
    }
}
