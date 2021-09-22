import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<String> comands = Arrays.stream(s.nextLine().split(" "))
                .collect(Collectors.toList());
        int i = 0;

        while (!comands.get(i).equals("Odd") && !comands.get(i).equals("Even")) {

            switch (comands.get(i)) {
                case "Delete":
                    int element = Integer.parseInt(comands.get(i + 1));
                    for (int j = 0; j < numbers.size(); j++) {

                        if (numbers.get(j).equals(element)) {
                            numbers.remove(j);
                            j--;
                        }
                    }
                    break;
                case "Insert":
                    int elementInser = Integer.parseInt(comands.get(i + 1));
                    int index = Integer.parseInt(comands.get(i + 2));
                    numbers.add(index, elementInser);

                    break;
                default:
                    break;
            }

            comands = Arrays.stream(s.nextLine().split(" ")).collect(Collectors.toList());
        }
        if (comands.get(i).equals("Odd")) {
            for (int j = 0; j < numbers.size(); j++) {
                int a = numbers.get(j);
                if (a % 2 != 0) {
                    System.out.print(a + " ");
                }
            }
        } else {
            for (int j = 0; j < numbers.size(); j++) {
                int a = numbers.get(j);
                if (a % 2 == 0) {
                    System.out.print(a + " ");
                }
            }
        }
    }
}
