import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int hours = Integer.parseInt(s.nextLine());
        int minutes = Integer.parseInt(s.nextLine());

        minutes+=30;

        if(minutes>59){
            minutes=minutes-60;
            hours++;
        }
        if(hours>23){
            hours=hours-24;
        }

        System.out.printf("%d:%02d",hours,minutes);
    }
}
