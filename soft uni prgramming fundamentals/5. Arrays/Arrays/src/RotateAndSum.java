import java.util.Arrays;
import java.util.Scanner;

public class RotateAndSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[] = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(s.nextLine());

        int[] sum = new int[arr.length];


        for (int count = 1; count <= n; count++) {

            int temp = arr[arr.length - 1];
            int con = 1;
            for (int reversIndex = arr.length - 1; reversIndex >= 1; reversIndex--) {
                arr[reversIndex] = arr[arr.length - 1 - con];
                con++;
                if (reversIndex == 1) {
                    arr[0] = temp;
                    break;
                }
            }
            for (int j = 0; j < sum.length; j++) {
                sum[j] = sum[j] + arr[j];
            }
        }

        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i] + " ");
        }

    }
}
