import java.util.Scanner;

public class X {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =Integer.parseInt(s.nextLine());

        for (int row = 0; row < (n/2); row++) {
            System.out.print(repeatStr(" ",row-1));
            System.out.print("x");
            int count = 0;
            System.out.print(repeatStr(" ",n-3-(row*2)));
            count+=2;
            System.out.println("x");
        }
        System.out.print(repeatStr(" ",n/2-1));
        System.out.println("x");

        for (int row = n/2; row>0; row--) {
            System.out.print(repeatStr(" ",row-2));
            System.out.print("x");
            System.out.print(repeatStr(" ",n-1-(2*row)));
            System.out.println("x");
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
