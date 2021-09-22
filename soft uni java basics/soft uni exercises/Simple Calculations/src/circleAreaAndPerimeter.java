import java.util.Scanner;

public class circleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        double r=Double.parseDouble(s.nextLine());
        double area= Math.PI*Math.pow(r,2);
        double perimeter=2*Math.PI*r;

        System.out.printf("Area = %f%nPerimeter = %f",area,perimeter);
    }
}
