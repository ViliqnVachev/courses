import java.util.Scanner;

public class Butterfly {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int width = 2 * n - 1;
        int higth = 2 * (n - 2) + 1;
        int left = n - 1;

        for (int row = 0; row < higth / 2; row++) {
            if (row % 2 == 0) {
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("*");
                }
                System.out.print("\\");
                System.out.print(" ");
                System.out.print("/");
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("-");
                }
                System.out.print("\\");
                System.out.print(" ");
                System.out.print("/");
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }


        //middle
        for (int middle = 0; middle < n - 1; middle++) {
            System.out.print(" ");
        }
        System.out.println("@");
        for (int row = 0; row < higth / 2; row++) {
            if (row % 2 == 0) {
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("*");
                }
                System.out.print("/");
                System.out.print(" ");
                System.out.print("\\");
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("-");
                }
                System.out.print("/");
                System.out.print(" ");
                System.out.print("\\");
                for (int i = 0; i < n - 2; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}

