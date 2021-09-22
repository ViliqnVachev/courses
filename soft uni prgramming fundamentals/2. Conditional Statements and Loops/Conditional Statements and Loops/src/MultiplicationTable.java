import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number =Integer.parseInt(s.nextLine());
        int sum =0;
        for (int i = 1; i <=10 ; i++) {
            sum=number*i;
            System.out.printf("%d X %d = %d%n",number,i,sum);
        }
    }
}
