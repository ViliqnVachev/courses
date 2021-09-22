import java.util.Scanner;

public class lili {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int years=Integer.parseInt(s.nextLine());
        double priceMachine=Double.parseDouble(s.nextLine());
        double toyPrice=Integer.parseInt(s.nextLine());
        double birthdayMoney=0;
        int toys=0;
        double count=0;

        for (int i = 1; i <= years; i++) {
            if(i%2==0){
                birthdayMoney+=10;
                count=count+birthdayMoney-1;
            }else{
                toys++;
            }
        }
        double saveMoney=count+(toyPrice*toys);
        double diff=(Math.abs(priceMachine-saveMoney));

        if(saveMoney>=priceMachine){
            System.out.printf("Yes! %.2f\n",diff);
        }else{
            System.out.printf("No! %.2f\n",diff);
        }
    }
}
