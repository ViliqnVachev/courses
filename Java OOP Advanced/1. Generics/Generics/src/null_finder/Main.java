package null_finder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(50);
        integerList.add(500);
        integerList.add(5000);
        integerList.add(null);


        System.out.println(ListUtils.getNullIndices(integerList));
    }
}
