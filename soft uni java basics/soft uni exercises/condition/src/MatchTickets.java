import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double money = Double.parseDouble(s.nextLine());
        String category = s.nextLine();
        int people = Integer.parseInt(s.nextLine());

        double transportMoney = -1;
        double normal = 249.99;
        double vip = 499.99;
        double priceTickets = -1;

        if ((people >= 1 && people <= 4) && category.equals("Normal")) {
            transportMoney = 0.75 * money;
            priceTickets = people * normal;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }

        } else if (people >= 5 && people <= 9 && category.equals("Normal")) {
            transportMoney = 0.60 * money;
            priceTickets = people * normal;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        } else if (people >= 10 && people <= 24 && category.equals("Normal")) {
            transportMoney = 0.50 * money;
            priceTickets = people * normal;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        } else if (people >= 25 && people <= 49 && category.equals("Normal")) {
            transportMoney = 0.40 * money;
            priceTickets = people * normal;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        } else if(people>=50&&category.equals("Normal")){
            transportMoney = 0.25 * money;
            priceTickets = people * normal;
            money = money - (transportMoney +priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        }else if ((people >= 1 && people <= 4) && category.equals("VIP")) {
            transportMoney = 0.75 * money;
            priceTickets = people * vip;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }

        } else if (people >= 5 && people <= 9 && category.equals("VIP")) {
            transportMoney = 0.60 * money;
            priceTickets = people * vip;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        } else if (people >= 10 && people <= 24 && category.equals("VIP")) {
            transportMoney = 0.50 * money;
            priceTickets = people * vip;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        } else if (people >= 25 && people <= 49 && category.equals("VIP")) {
            transportMoney = 0.40 * money;
            priceTickets = people * vip;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        } else {
            transportMoney = 0.25 * money;
            priceTickets = people * vip;
            money = money - (transportMoney + priceTickets);
            if (money <= 0) {
                money = Math.abs(money);
                System.out.printf("Not enough money! You need %.2f leva.", money);
            } else {
                System.out.printf("Yes! You have %.2f leva left.", money);
            }
        }


    }
}
