import java.util.Scanner;

public class Problem_01 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int paperRowCount= Integer.parseInt(s.nextLine());
        int platRowcount= Integer.parseInt(s.nextLine());
        double glueLitters=Double.parseDouble(s.nextLine());
        int discount=Integer.parseInt(s.nextLine());

        double pricePapepr=5.80;
        double pricePlat=7.20;
        double priceGlue=1.20;
      //  double discountPorcent=discount/100;

        double fullpricePaper=paperRowCount*pricePapepr;
        double fullpricePlat=platRowcount*pricePlat;
        double fullpriceGlue=glueLitters*priceGlue;
        double fullPriceMaterials=fullpriceGlue+fullpricePaper+fullpricePlat;

      //  double Fulldiscount=fullPriceMaterials*discountPorcent;

        double finPrice=fullPriceMaterials-((fullPriceMaterials*discount)/100);

        System.out.printf("%.3f",finPrice);

    }
}
