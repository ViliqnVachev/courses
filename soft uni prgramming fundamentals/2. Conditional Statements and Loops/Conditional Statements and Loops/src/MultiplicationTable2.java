import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number=Integer.parseInt(s.nextLine());
        int multiplier=Integer.parseInt(s.nextLine());

        int sum=0;

        if(multiplier>10){
            sum=number*multiplier;
            System.out.printf("%d X %d = %d",number,multiplier,sum);
        }

        for (int i = multiplier; i <=10 ; i++) {
            sum=number*i;
            System.out.printf("%d X %d = %d%n",number,i,sum);
        }
    }
}
