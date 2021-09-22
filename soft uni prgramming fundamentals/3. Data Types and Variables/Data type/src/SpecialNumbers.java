import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =Integer.parseInt(s.nextLine());

        for (int i = 1; i <= n; i++) {
            int sum=0;
            int number=i;
            while (number>0){
                sum=sum+ number%10;
                number=number/10;

            }
            boolean isSpecial = (sum==5) || (sum ==7) || (sum==11);
            System.out.printf("%d -> %s\n",i,isSpecial);
        }
    }
}
