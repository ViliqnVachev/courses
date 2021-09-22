import java.util.Scanner;

public class NumbersNtoOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        for (int i = n; i >0 ; i--) {
            System.out.println(i);
        }
    }
}
