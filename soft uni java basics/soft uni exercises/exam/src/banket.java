import java.util.Scanner;

public class banket {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people=Integer.parseInt(s.nextLine());
        int budget=Integer.parseInt(s.nextLine());

        int fullBudget=20*people;

        if(fullBudget<budget){

            int leftMoney=budget- fullBudget;
            double firework=leftMoney*40/100;
            double donation=leftMoney-firework;
            System.out.printf("Yes! %d lv are for fireworks and %d lv are for donation.",Math.round(firework),Math.round(donation));






        }else{
            double need= fullBudget-budget;
            System.out.printf("They won't have enough money to pay the covert. They will need %d lv more.",Math.round(need));
        }
    }
}
