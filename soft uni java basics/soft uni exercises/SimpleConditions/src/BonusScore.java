import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        int points=Integer.parseInt(s.nextLine());
        double bonuspoints;

        if(points<=100){
            bonuspoints=5;
        }else if(points<1000){
            bonuspoints=points*0.20;
        }else{
            bonuspoints=points*0.10;
        }

        if (points%2==0){
            bonuspoints++;
        }
        if(points%10==5){
            bonuspoints=bonuspoints+2;
        }
        System.out.println(bonuspoints);
        System.out.println(bonuspoints+points);
    }
}
