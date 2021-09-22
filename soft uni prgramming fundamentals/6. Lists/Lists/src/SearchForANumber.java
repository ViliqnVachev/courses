import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchForANumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> inputNumber = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr[0]; i++) {
            list.add(i, inputNumber.get(i));
        }

        while (arr[1] != 0) {
            list.remove(0);
            arr[1]--;
        }

        boolean isFind = false;

        for (int num : list) {
            if (num == arr[2]) {
                isFind = true;
            }
        }

        if (isFind) {
            System.out.println("YES!");
        } else {
            System.out.println("NO!");
        }
    }
}
