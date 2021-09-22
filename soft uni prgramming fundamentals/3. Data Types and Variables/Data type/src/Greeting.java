import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String firstName=s.nextLine();
        String lastName=s.nextLine();
        int age = Integer.parseInt(s.nextLine());

        System.out.printf("Hello, %s %s. You are %d years old.",firstName,lastName,age);
    }
}
