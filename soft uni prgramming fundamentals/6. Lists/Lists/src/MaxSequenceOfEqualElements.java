import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> list = Arrays.stream(s.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int position = 0;
        int bestPosition = 0;
        int bestLenght = 1;
        int lenght = 1;
        int nextNum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (nextNum >= list.size() - 1) {
                break;
            }
            nextNum++;
            if (list.get(i).equals(list.get(nextNum))) {
                lenght++;
                if (bestLenght < lenght) {
                    bestLenght = lenght;
                    bestPosition = position;
                }
            } else {
                position = nextNum;
                lenght = 1;
            }
        }

        List<Integer> maxSequence = new ArrayList<>();
        for (int i = 0; i < bestLenght; i++) {
            int temp = list.get(bestPosition + i);
            maxSequence.add(i, temp);
        }
        for (int num : maxSequence) {
            System.out.print(num + " ");
        }
    }
}
