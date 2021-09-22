import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
       String [] arr = s.nextLine().split(" ");
       String [] reversed = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i]=arr[arr.length-i-1];
        }
        System.out.println(String.join(" ",reversed));
    }
}
