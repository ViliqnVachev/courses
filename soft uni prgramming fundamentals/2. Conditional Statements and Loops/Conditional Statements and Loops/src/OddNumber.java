import java.util.Scanner;

public class OddNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = Integer.parseInt(s.nextLine());

        while (number % 2 == 0) {

            System.out.println("Please write an odd number.");
            number = Integer.parseInt(s.nextLine());

        }
        System.out.print("The number is: " + Math.abs(number));
    }
}
