import java.text.DecimalFormat;
        import java.util.Scanner;

public class BPMCounter {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int BPM = Integer.parseInt(s.nextLine());
        int beats = Integer.parseInt(s.nextLine());
        DecimalFormat df = new DecimalFormat("####.##");

        double result = (double)(beats/4);
        double seconds = beats * 60.0 / BPM;
        int minutes = (int) seconds / 60;
        seconds -= minutes * 60;

        System.out.printf("%s bars - %dm %.0fs",df.format(result),minutes,Math.floor(minutes));
    }
}
