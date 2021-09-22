import java.util.Scanner;

public class Problem_02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int daysOff=Integer.parseInt(s.nextLine());
        double leftFood=Double.parseDouble(s.nextLine());
        double firstDeer=Double.parseDouble(s.nextLine());
        double secondDeer=Double.parseDouble(s.nextLine());
        double thirdDeer=Double.parseDouble(s.nextLine());

        double FirstDeer=daysOff*firstDeer;
        double SeconDeer=daysOff*secondDeer;
        double ThirdDeer=daysOff*thirdDeer;

        double food=FirstDeer+SeconDeer+ThirdDeer;

        if(food>=leftFood){
            double need=food-leftFood;
               System.out.printf("%.0f more kilos of food are needed.",Math.ceil(need));
        }else{
            double left= leftFood-food;
            System.out.printf("%.0f kilos of food left.",Math.floor(left));

        }


        }

    }

