import java.util.Scanner;

public class as {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        int width=5*n;
        int hight=2*n+3;

        int count=1;
        int count2=1;
        int count3=0;
        //top
        System.out.print(repeatStr("-",n*2));
        System.out.print(repeatStr("*",n));
        System.out.print(repeatStr("-",n*2));
        System.out.println();

        int count4=2;
        int count5=2;
        int count6=2;
        int count7=1;
        int count8=1;

        for (int row = n/2; row > 0; row--) {
            System.out.print(repeatStr("-", n *2 - count4));
            count4+=2;
            System.out.print(repeatStr("*", count7));
            count7++;
            System.out.print(repeatStr("&", n  +count6 ));
            count6+=2;
            System.out.print(repeatStr("*", count8));
            count8++;
            System.out.print(repeatStr("-", n *2 -count5));
            count5+=2;
            System.out.println();

        }







        for (int row = 0; row < n / 2; row++) {
            System.out.print(repeatStr("-", n - 1 - row));
            System.out.print("**");

            System.out.print(repeatStr("~", width - 2 * n - 2 + count3));
            count3 += 2;
            System.out.print("**");
            System.out.print(repeatStr("-", n - 1 - row));
            System.out.println();
        }

        //middle
        System.out.print(repeatStr("-",n/2));
        System.out.print("*");
        System.out.print(repeatStr("|",width-(n+2)));
        System.out.print("*");
        System.out.print(repeatStr("-",n/2));
        System.out.println();

        //botton

        for (int row = 0; row < n/2; row++) {
            System.out.print(repeatStr("-",n/2+row));
            System.out.print("**");
            System.out.print(repeatStr("~",width-2*(n/2+row)-4));
            System.out.print("**");
            System.out.print(repeatStr("-",n/2+row));
            System.out.println();
        }

        for (int row = 0; row < n / 2; row++) {
            System.out.print(repeatStr("-",n+2*row));
            System.out.print(repeatStr("*",n/2-row));
            System.out.print(repeatStr("&",n*2-2*row));
            System.out.print(repeatStr("*",n/2-row));
            System.out.print(repeatStr("-",n+2*row));
            System.out.println();

        }
        System.out.print(repeatStr("-",n*2));
        System.out.print(repeatStr("*",n));
        System.out.print(repeatStr("-",n*2));
        System.out.println();
    }







    public static String repeatStr(String text, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
