import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ExactSumOffRealNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        BigDecimal bd =new BigDecimal(0);


        for (int i = 0; i < n; i++) {
            bd=bd.add(new BigDecimal(s.nextLine()));
        }
        System.out.println(bd);
    }
}
