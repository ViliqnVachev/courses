import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        double a=Double.parseDouble(s.nextLine());
        double h=Double.parseDouble(s.nextLine());

        double area=(a*h)/2;

        System.out.printf("Triangle area = %.2f",area);
    }
}
