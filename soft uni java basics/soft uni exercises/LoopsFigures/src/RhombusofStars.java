import java.util.Scanner;

public class RhombusofStars {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =Integer.parseInt(s.nextLine());

        for (int row = 1; row <=n ; row++) {

            for (int col = 0; col < n - row; col++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int stars = 0; stars < row - 1; stars++) {
                System.out.print(" *");
            }
            System.out.println();

        }
            for (int row = 1; row <= n-1; row++) {

                for (int stars = 0; stars <=n-row-1; stars++) {
                    System.out.print(" *");
                }
                System.out.print(" ");
                System.out.println();
                for (int spaces = 0; spaces <=row-1 ; spaces++) {
                    System.out.print(" ");
                }


            }
        }
    }

