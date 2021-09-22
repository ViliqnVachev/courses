import java.util.Scanner;

public class WireNet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lengthQrd=Integer.parseInt(s.nextLine());
        int widthQrd=Integer.parseInt(s.nextLine());
        double hightNet=Double.parseDouble(s.nextLine());
        double price=Double.parseDouble(s.nextLine());
        double weightNet=Double.parseDouble(s.nextLine());

        double widghtNet=2*lengthQrd+2*widthQrd;
        double priceNet=widghtNet*price;
        double areaNet=widghtNet*hightNet;
        double weightNet1=areaNet*weightNet;

        System.out.printf("%.0f%n%.2f%n%.3f",widghtNet,priceNet,weightNet1);
    }
}
