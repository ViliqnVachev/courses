import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SumOfArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int [] arr= Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int [] second= Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxLenght=Math.max(arr.length,second.length);
        int [] sum = new int[maxLenght];

        for (int i = 0; i < maxLenght; i++) {
            sum[i]=arr[i%arr.length]+second[i%second.length];
        }

        for (int num:sum ) {
            System.out.printf("%d ",num);
        }
    }
}
