import java.util.Arrays;
import java.util.Scanner;

public class ExtractMiddleElements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr = Arrays.stream(s.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = arr.length;

        if(n==1){
            System.out.printf("{ %d }",arr[0]);
        }else if(n%2==0){
            System.out.printf("{ %d, %d }",arr[arr.length/2-1],arr[arr.length/2]);
        }else {
            System.out.printf("{ %d, %d, %d }",arr[arr.length/2-1],arr[arr.length/2],arr[arr.length/2+1]);
        }


    }
}

