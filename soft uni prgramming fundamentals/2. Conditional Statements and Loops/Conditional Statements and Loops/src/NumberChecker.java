import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            int number = Integer.parseInt(s.nextLine());
            System.out.println("It is a number.");

        }
        catch(Exception ex){
            System.out.println("Invalid input!");
        }
    }
}

