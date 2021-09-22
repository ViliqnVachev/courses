import java.util.Scanner;

public class TrapezoidArea {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        double b1=Double.parseDouble(s.nextLine());
        double b2=Double.parseDouble(s.nextLine());
        double h=Double.parseDouble(s.nextLine());

        double area=((b1+b2)*h)/2;
        System.out.println("Trapezoid are = "+area);
    }
}
