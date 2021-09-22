import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TripleSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isTrue = false;


        for (int aindex = 0; aindex < arr.length; aindex++) {
            for (int bindex = aindex + 1; bindex < arr.length; bindex++) {
                int sum = arr[aindex] + arr[bindex];

                for (int cindex = 0; cindex < arr.length; cindex++) {
                    if (arr[cindex] == sum) {
                        System.out.printf("%d + %d == %d\n", arr[aindex], arr[bindex], arr[cindex]);
                        isTrue = true;
                        break;
                    }
                }
            }

        }
        if (!isTrue) {
            System.out.println("No");
        }
    }
}
