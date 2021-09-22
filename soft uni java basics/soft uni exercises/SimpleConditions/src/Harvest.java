import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int meters=Integer.parseInt(s.nextLine());
        double grape=Double.parseDouble(s.nextLine());
        int liters=Integer.parseInt(s.nextLine());
        int workers=Integer.parseInt(s.nextLine());

        double sumGrape=meters*grape;
        double wine=0.40*sumGrape/2.5;

        if (wine>=liters){
            double left=wine-liters;
            double person=left/workers;
            left=Math.ceil(left);
            person=Math.ceil(person);
            System.out.printf("Good harvest this year! Total wine: %d liters." +
                    "\n%.0f liters left -> %.0f liters per person.",(int)wine,left,person);
        }else{
            double left=liters-wine;
            left=Math.floor(left);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",left);
        }
    }
}
