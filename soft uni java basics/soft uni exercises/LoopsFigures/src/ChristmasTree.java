import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());



        for (int row = 0; row <=n; row++) {
            for (int spaces = 0; spaces <n-row ; spaces++) {
                System.out.print(" ");
            }
            for (int stars = 0; stars <=row-1; stars++) {
                System.out.print("*");
            }

            System.out.print(" | ");

            for (int i = 0; i <= row-1; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
