import java.util.Scanner;

public class Java {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n= Integer.parseInt(s.nextLine());

        int width=3*n+6;
        int height=3*n+1;

        for (int row = 0; row < n; row++) {
            System.out.print(repeatStr(" ",n));
            System.out.print(repeatStr("~ ",3));
            System.out.println();
        }

        System.out.print(repeatStr("=",width));
        System.out.println();
        for (int row = 0; row < height-n*2+2; row++) {
            System.out.print("|");
            System.out.println();
        }



    }



    public static String repeatStr(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
