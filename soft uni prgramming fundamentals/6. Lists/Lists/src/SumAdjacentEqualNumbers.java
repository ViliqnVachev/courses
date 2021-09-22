import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(s.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        int index = 0;

        while (index <= numbers.size()) {
            if(index==numbers.size()-1){
                break;
            }

            double currentNumber = numbers.get(index);
            double nextNumber = numbers.get(index + 1);

            if (currentNumber == nextNumber) {
                double sum = currentNumber + nextNumber;
                numbers.set(index, sum);
                numbers.remove(index + 1);
                index = 0;
            } else {
                index++;
            }

        }
        for (double num:numbers) {
            System.out.print(num+" ");

        }
    }
}
