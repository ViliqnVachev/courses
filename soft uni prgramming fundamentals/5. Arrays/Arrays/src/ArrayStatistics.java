import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int min=Integer.MAX_VALUE;
        int max =Integer.MIN_VALUE;
        long sum = 0;
        double avarage = 0;
        DecimalFormat df = new DecimalFormat("####.#######");

        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];

            if (min > arr[i]) {
                min = arr[i];
            }
            if(max<arr[i]){
                max=arr[i];
            }
        }
        avarage=1.0*sum/arr.length;

        System.out.println("Min = "+min);
        System.out.println("Max = "+max);
        System.out.println("Sum = "+sum);
        System.out.println("Average = "+df.format(avarage));

    }
}
