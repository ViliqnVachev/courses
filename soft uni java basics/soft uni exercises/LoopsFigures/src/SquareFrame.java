import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        System.out.print("+ ");
        for (int row = 0; row <n-2 ; row++) {
            System.out.print("- ");
        }
        System.out.println("+ ");
        for (int row = 0; row <n-2 ; row++) {
            System.out.print("| ");
            for (int col = 0; col < n-2; col++) {
                System.out.print("- ");

            }
            System.out.print("| ");
            System.out.println();
        }
        System.out.print("+ ");
        for (int row = 0; row <n-2 ; row++) {
            System.out.print("- ");
        }
        System.out.println("+ ");
    }
}
