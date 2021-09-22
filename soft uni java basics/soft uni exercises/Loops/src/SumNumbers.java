import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        int sum = 0;

        for (int i = 1; i <=n; i++) {
            int number = Integer.parseInt(s.nextLine());
            sum += number;

        }
        System.out.println(sum);
    }
}
