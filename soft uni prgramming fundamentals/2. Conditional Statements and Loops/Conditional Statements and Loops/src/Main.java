import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double grade = Double.parseDouble(s.nextLine());
        if (grade >=3.00){
            System.out.println("Passed!");
        }
    }
}
