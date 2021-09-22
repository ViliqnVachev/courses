import java.util.Scanner;

public class holliday {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nights = Integer.parseInt(s.nextLine());
        String destination = s.nextLine();
        String transport = s.nextLine();

        double trainprice = 2 * 22.30 + 3 * 12.50;
        double busprice = 2 * 45.00 + 3 * 37.00;
        double airplaineprice = 2 * 90.00 + 3 * 68.50;

        double sum = 0;
        double dog = 0;
        double finallPrice = 0;

        if (destination.equals("Miami")) {
            if (nights >= 1 && nights <= 10) {
                sum = nights * (2 * 24.99 + 3 * 14.99);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            } else if (nights >= 11 && nights <= 15) {
                sum = nights * (2 * 22.99 + 3 * 11.99);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            } else {
                sum = nights * (2 * 20.00 + 3 * 10.00);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            }


        } else if (destination.equals("Canary Islands")) {

            if (nights >= 1 && nights <= 10) {
                sum = nights * (2 * 32.50 + 3 * 28.50);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            } else if (nights >= 11 && nights <= 15) {
                sum = nights * (2 * 30.50 + 3 * 25.60);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            } else {
                sum = nights * (2 * 28.00 + 3 * 22.00);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            }


        } else if (destination.equals("Philippines")) {

            if (nights >= 1 && nights <= 10) {
                sum = nights * (2 * 42.99 + 3 * 39.99);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            } else if (nights >= 11 && nights <= 15) {
                sum = nights * (2 * 41.00 + 3 * 36.00);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            } else {
                sum = nights * (2 * 38.50 + 3 * 32.40);
                dog = (sum * 25) / 100;
                finallPrice = sum + dog;
            }
        }

        if (transport.equals("train")) {

            finallPrice = finallPrice + trainprice;

        } else if (transport.equals("bus")) {
            finallPrice = finallPrice + busprice;
        } else if (transport.equals("airplane")) {

            finallPrice = finallPrice + airplaineprice;
        }

        System.out.printf("%.3f", finallPrice);
    }
}
