import java.text.DecimalFormat;
import java.util.Scanner;

public class TouristInformation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String unit=s.nextLine();
        double value=Float.parseFloat(s.nextLine());
        DecimalFormat df= new DecimalFormat("#######.###");

        switch (unit){
            case "miles":
                double km=(value*1.60);
                System.out.printf("%s miles = %.2f kilometers",df.format(value),km);
                break;
            case "inches":
                double centimeters=(value*2.54);
                System.out.printf("%s inches = %.2f centimeters",df.format(value),centimeters);
                break;

            case "feet":
                double centimeters2=(value*30);
                System.out.printf("%s feet = %.2f centimeters",df.format(value),centimeters2);
                break;

            case "yards":
                double meters=(value*0.91);
                System.out.printf("%s yards = %.2f meters",df.format(value),meters);
                break;
            case "gallons":
                double liters=(value*3.8);
                System.out.printf("%s gallons = %.2f liters",df.format(value),liters);
                break;


        }
    }
}
