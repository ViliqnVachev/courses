import java.text.DecimalFormat;
import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        DecimalFormat df = new DecimalFormat("#.#########");
        double sumOdd = 0;
        double sumEven = 0;
        double oddMin = 1000000.0;
        double oddMax = -1000000.0;
        double evenMin = 1000000.0;
        double evenMax = -1000000.0;

        if (n == 0) {
            System.out.println("OddSum=0, OddMin=No, OddMax=No, EvenSum=0, EvenMin=No, EvenMax=No");
            return;
        }

        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(s.nextLine());
            if (i % 2 == 0) {
                sumEven += number;
                if (number < evenMin) {
                    evenMin = number;
                }
                if (number > evenMax) {
                    evenMax = number;
                }
            } else {
                sumOdd += number;
                if (number < oddMin) {
                    oddMin = number;
                }
                if (number > oddMax) {
                    oddMax = number;
                }
            }
        }
        if (evenMax == -1000000.0 && evenMin == 1000000.0) {
            System.out.printf("OddSum = %s\nOddMin = %s\nOddMax = %s\n" +
                    "EvenSum = %s\nEvenMin = No\nEvenMax = No", df.format(sumOdd), df.format(oddMin), df.format(oddMax), df.format(sumEven));
        } else if (oddMax == -1000000.0 && oddMin == 1000000.0) {
            System.out.printf("OddSum = %s\nOddMin = No\nOddMax = No\n" +
                    "EvenSum = %s\nEvenMin = %s\nEvenMax = %s", df.format(sumOdd), df.format(sumEven), df.format(evenMin), df.format(evenMax));
        } else {

            System.out.printf("OddSum = %s\nOddMin = %s\nOddMax = %s\n" +
                    "EvenSum = %s\nEvenMin = %s\nEvenMax = %s", df.format(sumOdd), df.format(oddMin), df.format(oddMax), df.format(sumEven), df.format(evenMin), df.format(evenMax));
        }
    }
}