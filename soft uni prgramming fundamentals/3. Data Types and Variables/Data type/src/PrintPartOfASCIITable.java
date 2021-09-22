import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int begin =Integer.parseInt(s.nextLine());
        int end =Integer.parseInt(s.nextLine());


        for (int i = begin; i <= end; i++) {

            System.out.print((char)i+" ");

        }
    }
}
