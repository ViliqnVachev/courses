import java.util.Scanner;

public class ExchangeVariableValues {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a =Integer.parseInt(s.nextLine());
        int b =Integer.parseInt(s.nextLine());
        int c ;

        System.out.printf("Before:\na = %d\nb = %d\nAfter:\na = %d\nb = %d",a,b,c=b,b=a);
    }
}
