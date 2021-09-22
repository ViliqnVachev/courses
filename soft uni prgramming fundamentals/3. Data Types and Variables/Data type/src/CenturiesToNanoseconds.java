import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class CenturiesToNanoseconds {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int centuries = Integer.parseInt(s.nextLine());
        int years = centuries * 100;
        int days = (int) (years * 365.2422);
        int hours = (days * 24);
        long minutes = hours * 60;
        long seconds = minutes * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes = %d seconds = %d000 milliseconds = %d000000 microseconds = %d000000000 nanoseconds",centuries,years,days,hours,minutes,seconds,seconds,seconds,seconds);


    }
}
