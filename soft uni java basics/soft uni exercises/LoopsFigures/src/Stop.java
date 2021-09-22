import java.util.Scanner;

public class Stop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int dots = n + 1;
        int dases = n * 2 + 1;
        int count=0;
        // first row

        for (int first = 0; first < dots; first++) {
            System.out.print(".");
        }
        for (int i = 0; i < dases; i++) {
            System.out.print("_");
        }
        for (int first = 0; first < dots; first++) {
            System.out.print(".");
        }
        System.out.println();

        //middle

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n - row; col++) {
                System.out.print(".");
            }
            System.out.print("//");
            System.out.print("_");
            for (int col = 0; col < n*2-1+count-1; col++) {
                System.out.print("_");

            }
                count+=2;


            System.out.print("\\\\");
            for (int col = 0; col <n-row ; col++) {
                System.out.print(".");
            }
            System.out.println();
        }
        System.out.print("//");
        for (int row = 0; row < n * 2 - 3; row++) {
            System.out.print("_");
        }
        System.out.print("STOP!");
        for (int row = 0; row < n * 2 - 3; row++) {
            System.out.print("_");
    }
        System.out.print("\\\\");
        System.out.println();

        //bottom

        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print(".");
            }
            System.out.print("\\\\");

            for (int col = 0; col < n*2-1+count; col++) {
                System.out.print("_");

            }
            count-=2;

            System.out.print("//");
            for (int i = 0; i <row ; i++) {
                System.out.print(".");
            }
            System.out.println();
        }
}
}
