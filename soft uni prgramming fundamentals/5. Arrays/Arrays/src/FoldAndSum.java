import java.util.Arrays;
import java.util.Scanner;

public class FoldAndSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = arr.length / 4;
        int[] fold = new int[k * 2];
        int[] sum = new int[k * 2];
        int countIndex = 0;

        for (int i = 0; i < 2 * k; i++) {
            if (i < k) {
                fold[i] = arr[k - 1 - i];
            } else {
                fold[i] = arr[arr.length - 1 - countIndex];
                countIndex++;
            }
        }

        for (int i = 0; i < 2 * k; i++) {
            sum[i] = arr[k + i];
        }
        for (int i = 0; i < fold.length; i++) {
            sum[i] = sum[i] + fold[i];
            System.out.print(sum[i] + " ");
        }

    }
}
