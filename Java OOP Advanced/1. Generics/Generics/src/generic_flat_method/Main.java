package generic_flat_method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        List<Double> doubleArrayList = new ArrayList<>();
        doubleArrayList.add(1.5);
        doubleArrayList.add(2.5);
        doubleArrayList.add(3.5);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged, integerList, doubleArrayList);

        List<Number> des = new ArrayList<>();
        ListUtils.flatten(des, jagged);
        System.out.println(des);


    }
}
