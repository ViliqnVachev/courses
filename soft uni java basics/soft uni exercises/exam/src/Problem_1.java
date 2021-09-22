import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double plosht=Double.parseDouble(s.nextLine());
        double kg=Double.parseDouble(s.nextLine());
        double brak=Double.parseDouble(s.nextLine());

        double fullKg=kg*plosht;
        double fullKgWithoutBrak=fullKg-brak;

        double rakiakg=fullKgWithoutBrak*45/100;
        double prodajba=fullKgWithoutBrak-rakiakg;

        double rakialitersprofit=(rakiakg/7.5)*9.80;
        double profit=prodajba*1.50;

        System.out.printf("%.2f%n%.2f",rakialitersprofit,profit);


    }
}
