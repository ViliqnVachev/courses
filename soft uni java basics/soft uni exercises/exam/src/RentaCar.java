import java.util.Scanner;

public class RentaCar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double budget = Double.parseDouble(s.nextLine());
        String seson = s.nextLine().toLowerCase();
        double sum = 0;

        if (budget <= 100) {
            System.out.println("Economy class");
            if (seson.equals("summer")) {
                sum = budget * 35/100;
                System.out.printf("Cabrio - %.2f", sum);
            } else {
                sum = budget * 65/100;
                System.out.printf("Jeep - %.2f", sum);
            }
        } else if (budget > 100 && budget <= 500) {
            System.out.println("Compact class");
            if (seson.equals("summer")) {
                sum = budget * 45/100;
                System.out.printf("Cabrio - %.2f", sum);
            } else {
                sum = budget * 80/100;
                System.out.printf("Jeep - %.2f", sum);
            }
        } else if (budget > 500) {
            System.out.println("Luxury class");
            if (seson.equals("summer") || seson.equals("winter")) {
                sum = budget * 90/100;
                System.out.printf("Jeep - %.2f", sum);
            }
        }
    }
}
