import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double money = Double.parseDouble(s.nextLine());
        String input = s.nextLine();
        String output = s.nextLine();
        double USD = 1.79549;
        double EUR = 1.95583;
        double GBR = 2.53405;


        if (input.equals("USD")) {
            money = money * USD;
        } else if (input.equals("GBR")) {
            money = money * GBR;
        } else if (input.equals("EUR")) {
            money = money * EUR;
        }

        if (output.equals("USD")) {
            money = money / USD;
        } else if (output.equals("GBR")) {
            money = money / GBR;
        } else if (output.equals("EUR")) {
            money = money / EUR;
        }
        System.out.printf("%.2f %s", money, output);
    }
}
