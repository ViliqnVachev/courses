import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String firstName=s.nextLine();
        String lastName=s.nextLine();
        int age=Integer.parseInt(s.nextLine());
        String town=s.nextLine();

        System.out.printf("You are %s %s, a %d-years old person from %s.",firstName,lastName,age,town);
    }
}
