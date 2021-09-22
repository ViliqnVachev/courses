import java.util.Scanner;

public class CircleAreaPrecision12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double r =Double.parseDouble(s.nextLine());
        double result = Math.PI*Math.pow(r,2);
        System.out.printf("%.12f",result);
    }
}
