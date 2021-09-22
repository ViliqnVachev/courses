import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Double> input = Arrays.stream(s.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        TreeMap<Double, Integer> count = new TreeMap<>();
        DecimalFormat df = new DecimalFormat("#.##########");

        for (double inputNumber : input) {
            if (count.containsKey(inputNumber)) {
                count.put(inputNumber, count.get(inputNumber) + 1);
            } else {
                count.put(inputNumber, 1);
            }
        }
        for (double item:count.keySet()) {
            System.out.printf("%s -> %d%n",df.format(item),count.get(item));
        }
    }
}
