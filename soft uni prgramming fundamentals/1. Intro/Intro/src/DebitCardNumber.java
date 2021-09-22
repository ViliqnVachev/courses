import java.util.Scanner;

public class DebitCardNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        int b = Integer.parseInt(s.nextLine());
        int c = Integer.parseInt(s.nextLine());
        int d = Integer.parseInt(s.nextLine());

        System.out.printf("%04d %04d %04d %04d",a,b,c,d);
    }
}
