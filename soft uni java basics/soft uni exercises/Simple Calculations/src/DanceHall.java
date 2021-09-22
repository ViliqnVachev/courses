import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        double l=Double.parseDouble(s.nextLine());
        double w=Double.parseDouble(s.nextLine());
        double a=Double.parseDouble(s.nextLine());

        double areaZala=(l*100)*(w*100);
        double areaGarderob=(a*100)*(a*100);
        double peika=areaZala/10;
        double prostranstvo=areaZala-areaGarderob-peika;

        System.out.printf("%.0f",Math.floor(prostranstvo/(40+7000)));

    }
}
