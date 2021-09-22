
import java.util.Arrays;
import java.util.Scanner;

public class PairsByDifference {
    public static void main(String[] args) {
        Scanner s=  new Scanner(System.in);
        int []arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int difference=Integer.parseInt(s.nextLine());
        int count=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]-arr[j]==difference){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
