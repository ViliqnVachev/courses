import java.math.BigDecimal;
import java.util.Scanner;

public class PracticeFloatingPoints {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        BigDecimal num1= new BigDecimal(s.nextLine());
        double num2 = Double.parseDouble(s.nextLine());
        BigDecimal num3= new BigDecimal(s.nextLine());

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);


    }
}
