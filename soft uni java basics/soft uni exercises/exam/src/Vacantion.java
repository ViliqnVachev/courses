import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double budget = Double.parseDouble(s.nextLine());
        String season = s.nextLine().toLowerCase();

        if(budget<=1000){
            // camp
            if(season.equals("summer")){
                double spent= 0.65*budget;
                System.out.printf("Alaska - Camp - %.2f",spent);
            }else{
                double spent= 0.45*budget;
                System.out.printf("Morocco - Camp - %.2f",spent);
            }
        }else if(budget>1000&&budget<=3000){
            //hurt
            if(season.equals("summer")){
                double spent= 0.80*budget;
                System.out.printf("Alaska - Hut - %.2f",spent);
            }else{
                double spent= 0.60*budget;
                System.out.printf("Morocco - Hut - %.2f",spent);
            }

        }else{
            //hotel
            if(season.equals("summer")){
                double spent= 0.90*budget;
                System.out.printf("Alaska - Hotel - %.2f",spent);
            }else{
                double spent= 0.90*budget;
                System.out.printf("Morocco - Hotel - %.2f",spent);
            }
        }

    }
}
