import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a = Double.parseDouble(s.nextLine());
        double b = Double.parseDouble(s.nextLine());
        double area = a * b;

        System.out.printf("%.2f",area);
    }
}
