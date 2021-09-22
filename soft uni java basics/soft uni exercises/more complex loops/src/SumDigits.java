import java.util.Scanner;

public class SumDigits   {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int count = 0;
        int sum = 0;

        while (n>0){
            count+= n%10;

            n=n/10;
        }
        System.out.println(count);
    }
}
