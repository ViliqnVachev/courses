import java.math.BigDecimal;
import java.util.Scanner;

public class operationBetweenNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a = Double.parseDouble(s.nextLine());
        double b = Double.parseDouble(s.nextLine());
        char operation =s.next().charAt(0);

        BigDecimal result =new BigDecimal("0.00");

        if (operation=='+') {
            result = new BigDecimal(a + b);

            if (result.intValueExact() % 2 == 0) {
                System.out.printf("%.0f + %.0f = %.0f - even", a, b, result);
            } else {
                System.out.printf("%.0f + %.0f = %.0f - odd", a, b, result);
            }

        } else if (operation=='-') {
            result = new BigDecimal(a - b);
            if (result.intValueExact() % 2 == 0) {
                System.out.printf("%.0f - %.0f = %.0f - even", a, b, result);
            } else {
                System.out.printf("%.0f - %.0f = %.0f - odd", a, b, result);
            }
        } else if (operation=='*') {
            result = new BigDecimal(a * b);
            if (result.intValueExact() % 2 == 0) {
                System.out.printf("%.0f * %.0f = %.0f - even", a, b, result);
            } else {
                System.out.printf("%.0f * %.0f = %.0f - odd", a, b, result);
            }
        } else if (operation=='/') {
            if (b == 0) {
                System.out.printf("Cannot divide %.0f by zero", a);
            } else {
                result = new BigDecimal(a / b);
                System.out.printf("%.0f / %.0f = %.2f ", a, b, result);
            }
        } else if (operation=='%') {

            if (b == 0) {
                System.out.printf("Cannot divide %.0f by zero", a);

            } else{
                result = new BigDecimal(a % b);
                System.out.printf("%.0f %% %.0f = %.0f ", a, b, result);
        }
    }
}
}
