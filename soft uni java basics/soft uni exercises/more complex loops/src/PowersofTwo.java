import java.util.Scanner;

public class PowersofTwo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i <= n; i++) {
        System.out.println((int)Math.pow(2,i));

        }

    }
}
