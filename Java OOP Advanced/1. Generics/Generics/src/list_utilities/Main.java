package list_utilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(50);
        integerList.add(500);
        integerList.add(5000);

        Integer maxInt=ListUtils.getMax(integerList);
        Integer minInt=ListUtils.getMin(integerList);

        System.out.println(minInt);
        System.out.println(maxInt);
    }
}
