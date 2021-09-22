import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        boolean b=true;
        int count=1;
        int sum=0;
        while(n>=1){

            count*=n;
            n--;
        }
        System.out.println(count);
    }
}
