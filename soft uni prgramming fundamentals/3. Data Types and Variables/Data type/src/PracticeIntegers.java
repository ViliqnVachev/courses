import java.math.BigDecimal;
import java.util.Scanner;

public class PracticeIntegers {
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        byte num1 = Byte.parseByte(s.nextLine());
        short num2 = Short.parseShort(s.nextLine());
        short num3=Short.parseShort(s.nextLine());
        int num4=Integer.parseInt(s.nextLine());
        long num5=Long.parseLong(s.nextLine());
        int num6=Integer.parseInt(s.nextLine());
        BigDecimal bg = new BigDecimal(s.nextLine());

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
        System.out.println(num6);
        System.out.println(bg);
    }
}
