import java.util.Scanner;

public class TestNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int m = Integer.parseInt(s.nextLine());
        int number = Integer.parseInt(s.nextLine());
        int sum = 0;
        int count = 0;
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                sum = sum + 3 * (i * j);
                count++;
                if (sum >= number) {
                    System.out.println(count + " combinations");
                    System.out.println("Sum: " + sum + " >= " + number);
                    return;
                }
            }
        }
        System.out.println(count + " combinations");
        System.out.println("Sum: " + sum);
    }
}
