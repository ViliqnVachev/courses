import java.util.Scanner;

public class ChristmasTreeStrBuilder {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        for (int row = 0; row <= n; row++) {
            System.out.print(repeatStr(" ",n-row-1));
            System.out.print(repeatStr("*",row-1));
            System.out.print(" | ");
            System.out.print(repeatStr("*",row-1));
            System.out.println();

        }

    }
    public static String repeatStr (String text,int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= count; i++) {
            sb.append(text);
        }
        return sb.toString();
    }
}
