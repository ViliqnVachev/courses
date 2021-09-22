import java.util.Scanner;

public class MilesToKilometers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double kilometers=Double.parseDouble(s.nextLine());
        double miles=1.60934;
        double milesToKilometers=kilometers*miles;

        System.out.printf("%.2f",milesToKilometers);
    }
}
