import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double priceTrip=Double.parseDouble(s.nextLine());
        int puzzles=Integer.parseInt(s.nextLine());
        int doll=Integer.parseInt(s.nextLine());
        int bears=Integer.parseInt(s.nextLine());
        int minions=Integer.parseInt(s.nextLine());
        int trucks=Integer.parseInt(s.nextLine());

        int toys=puzzles+doll+bears+minions+trucks;
        double price=puzzles*2.60+doll*3+bears*4.10+minions*8.20+trucks*2.0;

        if(toys>=50){
            double discountPice=price-(price*0.25);
            double profit=discountPice-(discountPice*0.10);
            if(profit>=priceTrip){
                double money=profit-priceTrip;
                System.out.printf("Yes! %.2f lv left.",money);
            }else{
                double money=priceTrip-profit;
                System.out.printf("Not enough money! %.2f lv needed.",money);
            }
        }else{
            double profit=price-(price*0.10);
            if(profit>=priceTrip){
                double money=profit-priceTrip;
                System.out.printf("Yes! %.2f left.",money);
            }else{
                double money=priceTrip-profit;
                System.out.printf("Not enough money! %.2f lv needed.",money);
        }
    }
}
}
