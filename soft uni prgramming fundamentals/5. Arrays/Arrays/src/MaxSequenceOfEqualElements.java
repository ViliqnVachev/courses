import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startPosition = 0;
        int lenght = 1;
        int nextPosition = 0;
        int bestStart = 0;
        int bestLenght = 0;

        for (int i = 0; i < arr.length; i++) {
            if (nextPosition >= arr.length - 1) {
                break;
            } else {
                nextPosition = i + 1;
            }
            if (arr[i] == arr[nextPosition]) {
                lenght++;
                if (bestLenght < lenght) {
                    bestStart = startPosition;
                    bestLenght = lenght;
                }
            } else {
                startPosition = nextPosition;
                lenght = 1;
            }
        }

        int[] equals = new int[bestLenght];
        for (int i = 0; i < equals.length; i++) {
            equals[i] = arr[bestStart + i];
        }

        for (int i = 0; i < equals.length; i++) {
            System.out.print(equals[i] + " ");
        }
    }
}
