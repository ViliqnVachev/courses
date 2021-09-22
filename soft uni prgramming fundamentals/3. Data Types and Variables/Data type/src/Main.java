import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int centuries = Integer.parseInt(s.nextLine());
        int years=centuries*100;
        int days =(int)(years*365.2422);
        int hours= (days*24);
        long minutes = hours*60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes\n",centuries,years,days,hours,minutes);
    }
}
