import java.util.Scanner;

public class RadianstoDegrees {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double rad=Double.parseDouble(s.nextLine());
        double deg=rad*(180/Math.PI);
        System.out.println(Math.round(deg));
    }
}
