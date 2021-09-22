import java.util.Scanner;

public class House {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int roofHigth = -1;
        boolean isEvan = n % 2 == 0;
        if (isEvan) {
            roofHigth = n / 2;
        } else {
            roofHigth = n / 2 + 1;
        }
        for (int row = 0; row < roofHigth; row++) {
            int dashesh = -1;
            int asterisk = -1;

            if (isEvan) {
                dashesh = n / 2 - 1;
                asterisk = 2;

            } else {
                dashesh = n / 2;
                asterisk = 1;
            }
            for (int j = 0; j < dashesh - row; j++) {
                System.out.print("-");

            }
            for (int i = 0; i < asterisk + 2 * row; i++) {
                System.out.print("*");
            }
            for (int j = 0; j < dashesh - row; j++) {
                System.out.print("-");

            }
            System.out.println();
        }
        for (int row = 0; row < n - roofHigth; row++) {
            System.out.print("|");
            for (int i = 0; i < n -2; i++) {
                System.out.print("*");
            }
            System.out.println("|");
        }
    }

    public static String repaeatStr(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
