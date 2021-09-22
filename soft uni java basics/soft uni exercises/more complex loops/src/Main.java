import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        System.out.println("The numbers are: ");
        for (int i = 1; i <= n; i+=3) {
            System.out.println(i);
        }
    }
}
