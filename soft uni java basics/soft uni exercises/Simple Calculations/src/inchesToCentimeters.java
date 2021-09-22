import java.util.Scanner;

public class inchesToCentimeters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("inches: ");
        double inches=Double.parseDouble(s.nextLine());
        double centimeters=inches*2.54;
        System.out.println("centimeters = "+centimeters);

    }
}
