import java.util.Scanner;

public class Problem_04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =Integer.parseInt(s.nextLine());
        int money =Integer.parseInt(s.nextLine());


        double sand=2.20;
        double magnet=1.50;
        double cup=5.00;
        double shirt=10.00;
        double result=0;

        for (int i = 0; i < n; i++) {
            String present=s.nextLine().toLowerCase();

            if(present.equals("sand clock")){
                result+=sand;
            }
            else if(present.equals("magnet")){
                //todo
                result+=magnet;
            }
            else if(present.equals("cup")){
                //todo
                result+=cup;
            }
            else if(present.equals("t-shirt")){
                //todo
                result+=shirt;
            }
        }

         if(result<=money){
            double more=money-result;
             System.out.printf("Santa Claus has %.2f more leva left!",more);
        }else{
             double need=result-money;
             System.out.printf("Santa Claus will need %.2f more leva.",need);
         }


    }
}
