import java.util.Scanner;

public class casttle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int hight = n;
        int row = n * 2 - 4 - 2 * (n / 2);
        boolean isEvan = n % 2 == 0;

        System.out.print("/");
        for (int ast = 0; ast < n / 2; ast++) {
            System.out.print("^");
        }
        System.out.print("\\");

        for (int midd = 0; midd < row; midd++) {
            System.out.print("_");
        }

        System.out.print("/");
        for (int ast = 0; ast < n / 2; ast++) {
            System.out.print("^");
        }
        System.out.println("\\");


        for (int i = 0; i < n - 3; i++) {
            System.out.print("|");
            System.out.print(repeatStr(" ", 2 * n - 2));
            System.out.println("|");
        }

        System.out.print("|");
        for (int ast = 0; ast < n / 2+1; ast++) {
            System.out.print(" ");
        }

        for (int midd = 0; midd < row; midd++) {
            System.out.print("_");
        }
        for (int ast = 0; ast < n / 2+1; ast++) {
            System.out.print(" ");
        }
        System.out.println("|");
            // bottom

        System.out.print("\\");
        for (int ast = 0; ast < n / 2; ast++) {
            System.out.print("_");
        }
        System.out.print("/");

        for (int midd = 0; midd < row; midd++) {
            System.out.print(" ");
        }

        System.out.print("\\");
        for (int ast = 0; ast < n / 2; ast++) {
            System.out.print("_");
        }
        System.out.println("/");
    }


    public static String repeatStr(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);

        }
        return sb.toString();
    }
}
