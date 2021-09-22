import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = Integer.parseInt(s.nextLine());
        int b = Integer.parseInt(s.nextLine());

        while (b !=0){
            int n=b;
            b=a%b;
            a=n;

        }
            System.out.println(a);
    }
}
