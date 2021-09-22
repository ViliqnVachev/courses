import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double distance = Double.parseDouble(s.nextLine());
        String input = s.nextLine();
        String output = s.nextLine();

        double mm = 1000;
        double cm = 100;
        double mi = 0.000621371192;
        double in = 39.3700787;
        double km = 0.001;
        double ft = 3.2808399;
        double yd = 1.0936133;

        if (input.equals("mm")) {
            distance = distance / mm;
        } else if (input.equals("cm")) {
            distance = distance / cm;
        } else if (input.equals("mi")) {
            distance = distance / mi;
        } else if (input.equals("in")) {
            distance = distance / in;
        } else if (input.equals("km")) {
            distance = distance / km;
        } else if (input.equals("ft")) {
            distance = distance / ft;
        } else if (input.equals("yd")) {
            distance = distance / yd;
        }


        if (output.equals("mm")) {
            distance = distance * mm;
        }
        else if (output.equals("cm")) {
            distance = distance * cm;
        }
        else if (output.equals("mi")) {
            distance = distance *mi;
        }
        else if (output.equals("in")) {
            distance = distance * in;
        }
        else if (output.equals("km")) {
            distance = distance * km;
        }
        else if (output.equals("ft")) {
            distance = distance * ft;
        }
        else if (output.equals("yd")) {
            distance = distance * yd;
        }

        System.out.printf("%.8f %s",distance, output);
    }

}
