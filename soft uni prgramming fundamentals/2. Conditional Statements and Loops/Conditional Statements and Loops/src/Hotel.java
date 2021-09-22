import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String months = s.nextLine().toLowerCase();
        int nights = Integer.parseInt(s.nextLine());
        double studioPrice = 0;
        double doublePrice = 0;
        double masterPrice = 0;

        if (months.equals("may") || months.equals("october")) {
            if (nights > 7 && months.equals("october")) {
                studioPrice = 50 * (nights - 1);
                studioPrice = studioPrice - (studioPrice * 0.05);
            } else if (nights > 7) {
                studioPrice = 50 * nights;
                studioPrice = studioPrice - (studioPrice * 0.05);
            } else {
                studioPrice = 50 * nights;
            }

            doublePrice = 65 * nights;
            masterPrice = 75 * nights;


        } else if (months.equals("june") || months.equals("september")) {

            if (nights > 7 && months.equals("september")) {
                studioPrice = 60 * (nights - 1);

            }else{
                studioPrice = 60 * nights;
            }
            if (nights > 14) {
                doublePrice = 72 * nights;
                doublePrice = doublePrice - (doublePrice * 0.1);
            } else {
                doublePrice = 72 * nights;

            }


            masterPrice = 82 * nights;

        } else if (months.equals("july") || months.equals("august") || months.equals("december")) {

            if (nights > 14) {
                masterPrice = 89 * nights;
                masterPrice = masterPrice - (masterPrice * 0.15);
            } else {
                masterPrice = 89 * nights;
            }
            studioPrice = 68 * nights;
            doublePrice = 77 * nights;
        }


        System.out.printf("Studio: %.2f lv.\nDouble: %.2f lv.\nSuite: %.2f lv.", studioPrice, doublePrice, masterPrice);
    }
}
