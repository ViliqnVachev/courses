import java.util.Scanner;

public class Cups {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int cups = Integer.parseInt(s.nextLine());
        int workers = Integer.parseInt(s.nextLine());
        int workDays = Integer.parseInt(s.nextLine());

        int worksHours=workers*workDays*8;
        double doneCups=(int)Math.floor(worksHours/5);

        if(doneCups>=cups){
            int extra=(int)doneCups-cups;
            double money=extra*4.2;
            System.out.printf("%.2f extra money",money);
        }else{
            int needCups=cups-(int)doneCups;
            double lose=needCups*4.2;
            System.out.printf("Losses: %.2f",lose);
        }
    }
}
