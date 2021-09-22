

import java.util.Scanner;

public class FastPrimeChecker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = Integer.parseInt(s.nextLine());



        for (int i = 2; i <= number; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            String isString = Boolean.toString(isPrime);
            isString=upperCaseFirst(isString);



            System.out.println(i+" -> "+isString);


        }
    }

    public static String upperCaseFirst(String value) {

        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }

}
