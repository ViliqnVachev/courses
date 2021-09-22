import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double priceWiskey=Double.parseDouble(s.nextLine());
        double beer=Double.parseDouble(s.nextLine());
        double wine=Double.parseDouble(s.nextLine());
        double rakia=Double.parseDouble(s.nextLine());
        double wiskey=Double.parseDouble(s.nextLine());

        double priceRakia=priceWiskey/2.0;
        double priceWine=priceRakia-(priceRakia*0.40);
        double priceBeer=priceRakia-(priceRakia*0.80);

        double moneyWiskey=wiskey*priceWiskey;
        double moneyWine=wine*priceWine;
        double moneyBeer=beer*priceBeer;
        double moneyRakia=rakia*priceRakia;

        double fullMoney=moneyBeer+moneyRakia+moneyWine+moneyWiskey;
        System.out.printf("%.2f",fullMoney);
    }
}
