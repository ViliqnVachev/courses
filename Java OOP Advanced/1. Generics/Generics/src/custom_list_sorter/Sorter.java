package custom_list_sorter;

import java.util.List;

public class Sorter {

    public static <T extends Comparable<T>> void sort(MyCustomList<T> list) {
        list.sort();

    }
}
