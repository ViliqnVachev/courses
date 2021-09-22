import java.util.Scanner;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        int b = Integer.parseInt(s.nextLine());
        int sum = a + b;

        System.out.printf("%d + %d = %d", a, b, sum);
    }
}
