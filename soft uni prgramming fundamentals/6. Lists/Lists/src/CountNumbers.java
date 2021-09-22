import java.util.*;
import java.util.stream.Collectors;

public class CountNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> input = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();
        List<Integer> counter = new ArrayList<>();

        Collections.sort(input);
        for (int firstElement = 0; firstElement < input.size(); firstElement++) {
            int counts = 0;
            int curentNUmber = input.get(firstElement);
            numbers.add(input.get(firstElement));
            for (int i = 0; i < input.size(); i++) {
                if (curentNUmber == input.get(i)) {
                    counts++;
                    input.remove(i);
                    i--;
                }
            }
            counter.add(counts);
            firstElement--;
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.printf("%d -> %d%n",numbers.get(i),counter.get(i));
        }

    }
}
