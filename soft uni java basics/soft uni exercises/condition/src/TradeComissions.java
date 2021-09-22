import java.util.Scanner;

public class TradeComissions {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String city = s.nextLine().toLowerCase();
        double trade = Double.parseDouble(s.nextLine());

        double comission = -1;

        if (city.equals("sofia")) {
            if (trade < 0) {
                System.out.println("error");
            } else if (trade >= 0 && trade <= 500) {
                comission = 5;

            } else if (trade <= 1000) {
                comission = 7;
            } else if (trade <= 10000) {
                comission = 8;
            } else if (trade > 10000) {
                comission = 12;
            }
        }else if (city.equals("varna")){
            if (trade < 0) {
                System.out.println("error");
            } else if (trade >= 0 && trade <= 500) {
                comission = 4.5;

            } else if (trade <= 1000) {
                comission = 07.5;
            } else if (trade <= 10000) {
                comission = 10;
            } else if (trade > 10000) {
                comission = 13;
            }
        }else if(city.equals("plovdiv")){
            if (trade < 0) {
                System.out.println("error");
            } else if (trade >= 0 && trade <= 500) {
                comission = 5.5;

            } else if (trade <= 1000) {
                comission = 8;
            } else if (trade <= 10000) {
                comission = 12;
            } else if (trade > 10000) {
                comission = 14.5;
            }
        }else{
            System.out.println("error");
            return;
        }

        System.out.printf("%.2f",(comission*trade)/100);
    }
}
