import java.text.DecimalFormat;
import java.util.Scanner;

public class ConvertSpeedUnits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int distance =Integer.parseInt(s.nextLine());
        int hours =Integer.parseInt(s.nextLine());
        int minutes =Integer.parseInt(s.nextLine());
        int seconds =Integer.parseInt(s.nextLine());
        int time = seconds+minutes*60+hours*3600;

        DecimalFormat df = new DecimalFormat("0.#######");

        float metersPerSec = (float)distance/time;
        float kilometersPerHour= ((float)distance/1000)/((float)time/3600);
        float milesPerHour= ((float)distance/1609)/((float)time/3600);
        System.out.println(df.format(metersPerSec));
        System.out.println(df.format(kilometersPerHour));
        System.out.println(df.format(milesPerHour));
    }
}
