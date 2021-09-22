import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double dohod = Double.parseDouble(s.nextLine());
        double uspeh = Double.parseDouble(s.nextLine());
        double zaplata = Double.parseDouble(s.nextLine());

        if (dohod < zaplata && uspeh < 5.50 && uspeh >= 4.50) {
            double stipendiq = zaplata * 0.35;
            System.out.printf("You get a Social scholarship %.0f BGN", stipendiq);
        } else if (dohod < zaplata && uspeh >= 5.50) {
            double social = zaplata * 0.35;
            double stipendiq = uspeh * 25;
            if (social > stipendiq) {
                System.out.printf("You get a Social scholarship %.0f BGN", social);
            } else {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", stipendiq);
            }
        } else if (dohod >= zaplata && uspeh >= 5.50) {
            double stipendiq = uspeh * 25;
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(stipendiq));
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
