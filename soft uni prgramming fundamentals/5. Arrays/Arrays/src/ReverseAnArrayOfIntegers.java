

import java.util.Scanner;

public class ReverseAnArrayOfIntegers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = Integer.parseInt(s.nextLine());

        int [] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i]=Integer.parseInt(s.nextLine());

        }

        for (int i = arr.length-1; i >=0 ; i--) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
