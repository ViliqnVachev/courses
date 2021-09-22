import java.text.DecimalFormat;
import java.util.Scanner;

public class BeverageLabels {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String name =s.nextLine();
        double volume=Integer.parseInt(s.nextLine());
        double energyContent=Integer.parseInt(s.nextLine());
        double sugar=Integer.parseInt(s.nextLine());

        double energyFull=(energyContent*volume/100.00);
        double sugarFull=(sugar*volume/100.00);
        DecimalFormat df=new DecimalFormat("######################.###");

        System.out.printf("%sml %s:%n%Skcal, %sg sugars",df.format(volume),name,df.format(energyFull),df.format(sugarFull));
    }
}
