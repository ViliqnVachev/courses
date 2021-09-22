import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(s.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        Collections.sort(numbers);

        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.printf("%f <= ",numbers.get(i));
        }
        System.out.printf("%f",numbers.get(numbers.size()-1));
    }
}
