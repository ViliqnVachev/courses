import java.util.Scanner;

public class Rectangle2DArea {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x1 = Double.parseDouble(s.nextLine());
        double y1 = Double.parseDouble(s.nextLine());
        double x2 = Double.parseDouble(s.nextLine());
        double y2 = Double.parseDouble(s.nextLine());

        double base = Math.max(x1, x2) - Math.min(x1, x2);
        double hight = Math.max(y1, y2) - Math.min(y1, y2);

        double area = base * hight;
        double perimeter=(base+hight)*2;
        System.out.printf("%f%n%f",area,perimeter);
    }
}
