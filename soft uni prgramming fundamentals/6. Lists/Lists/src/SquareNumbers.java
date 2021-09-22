import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SquareNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int index = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            int sqrtNum=num;
            if (Math.sqrt(sqrtNum) == (int) Math.sqrt(sqrtNum)) {

                numbers.set(index, num);
                index++;

            }else {
                numbers.remove(i);
                i--;
            }

        }
        Collections.sort(numbers);
        Collections.reverse(numbers);
        for (int num : numbers) {
            System.out.print(num+" ");
        }
    }
}

