import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int sum = 0;
        int j = 1;
        for (int i = 1; i <= n; i++) {
            System.out.println(j);
            sum = sum + j;
            j += 2;
        }
        System.out.println("Sum: " + sum);
    }
}
