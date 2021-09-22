import java.util.Scanner;

public class RestaurantDiscount {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people = Integer.parseInt(s.nextLine());
        String pack = s.nextLine();

        double price = 0;
        double totalPrice = 0;

        if (people <= 50) {
            price = 2500;
            if (pack.equals("Normal")) {
                price = price + 500;
                totalPrice = price - (price * 0.05);
            } else if (pack.equals("Gold")) {
                price = price + 750;
                totalPrice = price - (price * 0.1);
            } else {
                price = price + 1000;
                totalPrice = price - (price * 0.15);
            }
            double pricePerPerson = totalPrice / people;

            System.out.printf("We can offer you the Small Hall\nThe price per person is %.2f$",pricePerPerson);

        } else if (people > 50 && people <= 100) {
            price = 5000;
            if (pack.equals("Normal")) {
                price = price + 500;
                totalPrice = price - (price * 0.05);
            } else if (pack.equals("Gold")) {
                price = price + 750;
                totalPrice = price - (price * 0.1);
            } else {
                price = price + 1000;
                totalPrice = price - (price * 0.15);
            }
            double pricePerPerson = totalPrice / people;

            System.out.printf("We can offer you the Terrace\nThe price per person is %.2f$",pricePerPerson);

        } else if (people > 100 && people <= 120) {
            price = 7500;
            if (pack.equals("Normal")) {
                price = price + 500;
                totalPrice = price - (price * 0.05);
            } else if (pack.equals("Gold")) {
                price = price + 750;
                totalPrice = price - (price * 0.1);
            } else {
                price = price + 1000;
                totalPrice = price - (price * 0.15);
            }
            double pricePerPerson = totalPrice / people;

            System.out.printf("We can offer you the Great Hall\nThe price per person is %.2f$",pricePerPerson);
        }
        else{
            System.out.println("We do not have an appropriate hall.");
        }


    }
}
