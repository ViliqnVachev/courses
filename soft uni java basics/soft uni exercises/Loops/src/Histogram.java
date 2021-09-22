import java.text.DecimalFormat;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        double count5 = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
            int numbers = Integer.parseInt(s.nextLine());
            if (numbers >= 1 && numbers < 200) {
                count1++;
            } else if (numbers >= 200 && numbers <= 399) {
                count2++;
            } else if (numbers >= 400 && numbers <= 599) {
                count3++;
            } else if (numbers >= 600 && numbers <= 799) {
                count4++;
            } else if (numbers >= 800 && numbers <= 1000) {
                count5++;
            }
        }
        System.out.println(df.format((count1 / n) * 100) + "%");
        System.out.println(df.format((count2 / n) * 100) + "%");
        System.out.println(df.format((count3 / n) * 100) + "%");
        System.out.println(df.format((count4 / n) * 100) + "%");
        System.out.println(df.format((count5 / n) * 100) + "%");
    }
}
