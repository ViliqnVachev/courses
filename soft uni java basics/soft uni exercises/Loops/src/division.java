import java.text.DecimalFormat;
import java.util.Scanner;

public class division {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        double count1 = 0;
        double count2 = 0;
        double count3 = 0;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(s.nextLine());
            if (number % 2 == 0) {
                count1++;

            }
            if (number % 3 == 0) {
                count2++;

            }
            if (number % 4 == 0) {
                count3++;

            }
        }
        System.out.printf("%.2f%%\n", (count1 / n) * 100);
        System.out.printf("%.2f%%\n", (count2 / n) * 100);
        System.out.printf("%.2f%%\n", (count3 / n) * 100);
    }
}
