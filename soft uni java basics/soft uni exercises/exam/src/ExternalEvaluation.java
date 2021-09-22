import java.util.Scanner;

public class ExternalEvaluation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        for (int i = 0; i < n; i++) {
            double points = Double.parseDouble(s.nextLine());
            if (points >= 0 && points < 22.5) {
                count2++;
            } else if (points >= 22.5 && points < 40.5) {
                count3++;
            } else if (points >= 40.5 && points < 58.5) {
                count4++;
            } else if (points >= 58.5 && points < 76.5) {
                count5++;
            } else if (points >= 76.5 && points <= 100) {
                count6++;
            }
        }
        System.out.printf("%.2f%% poor marks%n",(double)count2/n*100);
        System.out.printf("%.2f%% satisfactory marks%n",(double)count3/n*100);
        System.out.printf("%.2f%% good marks%n",(double)count4/n*100);
        System.out.printf("%.2f%% very good marks%n",(double)count5/n*100);
        System.out.printf("%.2f%% excellent marks%n",(double)count6/n*100);
    }
}
