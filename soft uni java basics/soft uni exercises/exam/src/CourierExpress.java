import java.util.Scanner;

public class CourierExpress {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double kilogram = Double.parseDouble(s.nextLine());
        String typeServie = s.nextLine().toLowerCase();
        int distanceKm = Integer.parseInt(s.nextLine());

        double price = 0;
        double express = 0;
        double fullPrice = 0;

        double expensive1 =  0.8 * 0.03;
        double expensive2 =  0.4 * 0.05;
        double expensive3 =  0.05 * 0.10;
        double expensive4 =  0.02 * 0.15;
        double expensive5 =  0.01 * 0.20;

        if (typeServie.equals("standard")) {
            if (kilogram < 1) {
                price = 0.03 * distanceKm;
            } else if (kilogram >= 1 && kilogram <= 10) {
                price = 0.05 * distanceKm;
            } else if (kilogram >= 11 && kilogram <= 40) {
                price = 0.10 * distanceKm;
            } else if (kilogram >= 41 && kilogram <= 90) {
                price = 0.15 * distanceKm;
            } else if (kilogram >= 91 && kilogram <= 150) {
                price = 0.20 * distanceKm;
            }

            System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", kilogram, price);
        }
        if (typeServie.equals("express")) {
            if (kilogram < 1) {
                price = 0.03 * distanceKm;
                express = (expensive1 * kilogram)* distanceKm;
                fullPrice = price + express;
            } else if (kilogram >= 1 && kilogram <= 10) {
                price = 0.05 * distanceKm;
                express = (expensive2 *kilogram)* distanceKm;
                fullPrice = price + express;
            } else if (kilogram >= 11 && kilogram <= 40) {
                price = 0.10 * distanceKm;
                express = (expensive3 * kilogram)*distanceKm;
                fullPrice = price + express;
            } else if (kilogram >= 41 && kilogram <= 90) {
                price = 0.15 * distanceKm;
                express = (expensive4 * kilogram)*distanceKm;
                fullPrice = price + express;
            } else if (kilogram >= 91 && kilogram <= 150) {
                price = 0.20 * distanceKm;
                express = (expensive5 *kilogram)* distanceKm;
                fullPrice = price + express;
            }

            System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", kilogram, fullPrice);
        }
    }
}
