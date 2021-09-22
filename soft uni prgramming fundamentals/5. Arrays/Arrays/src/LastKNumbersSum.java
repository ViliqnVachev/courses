import java.util.Scanner;

public class LastKNumbersSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size =Integer.parseInt(s.nextLine());
        int counter = Integer.parseInt(s.nextLine());

        long[] arr = new long[size];
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            long sum = 0;
            for (int j = i- counter; j <= i-1; j++) {

                if (j >= 0) {
                    sum+=arr[j];
                }
            }

            arr[i] = sum;

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
