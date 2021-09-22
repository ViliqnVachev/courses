import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int d =Integer.parseInt(s.nextLine());
        int sh =Integer.parseInt(s.nextLine());
        int h =Integer.parseInt(s.nextLine());
        double pr=Double.parseDouble(s.nextLine());

        double p=pr*0.01;
        double obem=d*sh*h*0.001;

        double realObem=obem*(1-p);

        System.out.printf("%.3f",realObem);

    }
}
