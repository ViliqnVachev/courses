import java.util.Scanner;

public class PointonRectangleBorder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x1 = Double.parseDouble(s.nextLine());
        double y1 = Double.parseDouble(s.nextLine());
        double x2 = Double.parseDouble(s.nextLine());
        double y2 = Double.parseDouble(s.nextLine());
        double x = Double.parseDouble(s.nextLine());
        double y = Double.parseDouble(s.nextLine());

        boolean isOnLeft = x == x1 && y >= y1 && y <= y2;
        boolean isOnRight = x == x2 && y >= y1 && y <= y2;
        boolean isOnTop = y == y1 && x >= x1 && x <= x2;
        boolean isOnBotom = y == y2 && x >= x1 && x <= x2;
        if (isOnRight || isOnLeft || isOnBotom || isOnTop) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
