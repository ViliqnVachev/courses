import java.text.DecimalFormat;
import java.util.Scanner;

public class PipeInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double p1h = p1 * h;
        double p2h = p2 * h;
        DecimalFormat df = new DecimalFormat("#.#####");
        if (p1h + p2h > v) {
            double overflow = (p1h + p2h) - v;
            String answer1  = df.format(h).toString();
            System.out.printf("For %s hours the pool overflows with %.01f liters.", answer1, overflow);
        } else {
            double vp = p1h + p2h;
            double percentage1 = Math.floor((p1h / vp) * 100);
            double percentage2 = Math.floor((p2h / vp) * 100);
            double percentageFull = Math.floor((vp / v) * 100);
            String answer1  = df.format(percentageFull).toString();
            String answer2  = df.format(percentage1).toString();
            String answer3  = df.format(percentage2).toString();
            System.out.printf("The pool is %s%% full. Pipe 1: %s%%. Pipe 2: %s%%.", answer1, answer2, answer3);
        }
        //code ends here
    }
}