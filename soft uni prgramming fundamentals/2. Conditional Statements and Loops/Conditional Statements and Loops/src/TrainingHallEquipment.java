import java.util.Scanner;

public class TrainingHallEquipment {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double budget=Double.parseDouble(s.nextLine());
        int itemsNumber=Integer.parseInt(s.nextLine());
        double totalPrice=0.0;

        for (int i = 0; i < itemsNumber; i++) {
            String items= s.nextLine();
            double priceItem=Double.parseDouble(s.nextLine());
            int countItem=Integer.parseInt(s.nextLine());
            if(countItem>1){
                System.out.printf("Adding %d %ss to cart.\n",countItem,items);
            }else{
                System.out.printf("Adding %d %s to cart.\n",countItem,items);
            }

            double curretnPrice=(double)(priceItem*countItem);
            totalPrice=totalPrice+curretnPrice;


        }
        System.out.printf("Subtotal: $%.2f\n",totalPrice);

        if(budget>=totalPrice){
            double left=budget-totalPrice;
            System.out.printf("Money left: $%.2f",left);
        }else{
            double need=totalPrice-budget;
            System.out.printf("Not enough. We need $%.2f more.",need);
        }
    }
}
