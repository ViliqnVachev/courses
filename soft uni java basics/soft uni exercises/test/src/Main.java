import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int days = Integer.parseInt(s.nextLine());
        double kilometers = Double.parseDouble(s.nextLine());

        double a = 0;
        double c = 0;
        double result = kilometers;

        double finallKm = 0;
        for (int i = 1; i <= days; i++) {
            int procente = Integer.parseInt(s.nextLine());
            a = (procente * result) / 100;
            c = result + a;
            result = c;
            finallKm += result;

        }
        finallKm = finallKm + kilometers;

        if(finallKm<1000){
            double need=1000-finallKm;
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers",Math.ceil(need));
        }else{
            double done=finallKm-1000;
            System.out.printf("You've done a great job running %.0f more kilometers!",Math.ceil(done));
        }


    }
}
