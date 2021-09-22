import java.text.DecimalFormat;
import java.util.Scanner;

public class RectangleProperties {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double width=Double.parseDouble(s.nextLine());
        double height=Double.parseDouble(s.nextLine());
        DecimalFormat df =new DecimalFormat("0.#############");

        double perimeter= (width+height)*2;
        double area= width*height;
        double c= Math.sqrt(Math.pow(width,2)+Math.pow(height,2));

        System.out.println(df.format(perimeter));
        System.out.println(df.format(area));
        System.out.println(df.format(c));
    }
}
