import java.text.DecimalFormat;
import java.util.Scanner;

public class Megapixels {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int width =Integer.parseInt(s.nextLine());
        int hight =Integer.parseInt(s.nextLine());

        double result = (double)(width*hight)/1000000;
        DecimalFormat df = new DecimalFormat("#######.#");

        System.out.printf("%dx%d => %sMP",width,hight,df.format(result));
    }
}
