package generic_swap_method_string;

import java.util.List;

public class Box<T extends Comparable<T>> {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s: %s", this.item.getClass().getName(), this.item));

        return sb.toString();
    }
}
