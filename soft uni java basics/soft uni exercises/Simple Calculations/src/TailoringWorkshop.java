import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int count=Integer.parseInt(s.nextLine());
        double duljina=Double.parseDouble(s.nextLine());
        double sh=Double.parseDouble(s.nextLine());

        double pokrivki=count*(duljina+(2*0.30))*(sh+(2*0.30));
        double kareta=count*(duljina/2)*(duljina/2);



        double priceUSD=(7*pokrivki)+(kareta*9);

        System.out.printf("%.2f USD\n%.2f BGN",priceUSD,priceUSD*1.85);
    }
}
