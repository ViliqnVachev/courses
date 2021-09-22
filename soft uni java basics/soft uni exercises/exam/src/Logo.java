import java.util.Scanner;

public class Logo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int hight = 4 * n - 2;
        int width = 12 * n - 5;
        int b =0;

        for (int row = 0; row < hight / 2; row++) {
            System.out.print(repeatStr(".", width / 2 - row * 3));
            System.out.print(repeatStr("#", row * 6 + 1));
            System.out.print(repeatStr(".", width / 2 - row * 3));

            System.out.println();
        }
        System.out.print(repeatStr("#", width));
        System.out.println();

        if(n%2==1){
            b=n/2+1;
        }else{
            b=n/2;
        }
        for (int row = 0; row <b ; row++) {
            System.out.print("|");
            System.out.print(repeatStr(".",row + 2));
            System.out.print(repeatStr("#", width-6-2*row));
            System.out.print(repeatStr(".",row + 3));
            System.out.println();

        }
        for (int i = 0; i < hight/2-b-1; i++) {
            System.out.print(repeatStr(".",i + 2));
            System.out.print(repeatStr("#", width-6-2));
            System.out.print(repeatStr(".",i + 3));
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
