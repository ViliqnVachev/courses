import java.util.Scanner;

public class Sock {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int hight = 3 * n + 3;
        int width = 2 * n + 2;


        System.out.print("|");
        System.out.print(repeatStr("-", 2 * n));
        System.out.println("|");
        System.out.print("|");
        System.out.print(repeatStr("*", 2 * n));
        System.out.println("|");
        System.out.print("|");
        System.out.print(repeatStr("-", 2 * n));
        System.out.println("|");
int count=0;
        for (int row = 0; row < 2*n-3; row++) {
            System.out.print("|");
            System.out.print(repeatStr("-",width/2-count));
                count+=2;
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
