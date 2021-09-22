package generic_add_all_method;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("The list is empty");
        }

        T min = list.get(0);
        for (T t : list) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("The list is empty");
        }

        T max = list.get(0);
        for (T t : list) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }

    public static List<Integer> getNullIndices(List<?> list) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static <T> void flatten(List<? super T> des, List<List<? extends T>> src) {
        for (List<? extends T> list : src) {
            des.addAll(list);
        }
    }

    public static <T> void addAll(List<? super T> des, List<? extends T> src) {
        des.addAll(src);
    }
}
