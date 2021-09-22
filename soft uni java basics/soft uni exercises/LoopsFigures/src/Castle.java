import java.util.Scanner;

public class Castle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int hight = n;
        int widtht = 2 * n;
        int asterisk = -1;
        asterisk = n / 2;
            //first tower
        System.out.print("/");
        for (int teower = 0; teower < asterisk; teower++) {
            System.out.print("^");
        }
        System.out.print("\\");
        if (n > 4) {
            for (int i = 0; i < asterisk; i++) {
                System.out.print("_");
            }

        } else {
            System.out.print("");
        }
        System.out.print("/");
        for (int teower = 0; teower < asterisk; teower++) {
            System.out.print("^");
        }
        System.out.println("\\");

        //middle

        for (int row = 0; row < n - 3; row++) {


            System.out.print("|");
            for (int middle = 0; middle < 2 * n - 2; middle++) {
                System.out.print(" ");
            }
            System.out.println("|");


        }
        System.out.print("|");
        for (int i = 0; i < asterisk + 1; i++) {
            System.out.print(" ");
        }
        if (n > 4) {
            for (int i = 0; i < asterisk; i++) {
                System.out.print("_");
            }
        } else {
            System.out.print("");
        }
        for (int i = 0; i < asterisk + 1; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        //bottom
        System.out.print("\\");
        for (int teower = 0; teower < asterisk; teower++) {
            System.out.print("_");
        }
        System.out.print("/");
        if (n > 4) {
            for (int i = 0; i < asterisk; i++) {
                System.out.print(" ");
            }

        } else {
            System.out.print("");
        }
        System.out.print("\\");
        for (int teower = 0; teower < asterisk; teower++) {
            System.out.print("_");
        }
        System.out.println("/");
    }
}
