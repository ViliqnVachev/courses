import java.util.Arrays;
import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int mostFrequentNumber = 0;
        int mostCount = 0;


        for (int takenNumber = 0; takenNumber < arr.length; takenNumber++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[takenNumber] == arr[j]) {
                    count++;
                }
            }
            if (mostCount < count) {
                mostCount = count;
                mostFrequentNumber = arr[takenNumber];
            }
        }
        System.out.println(mostFrequentNumber);
    }
}
