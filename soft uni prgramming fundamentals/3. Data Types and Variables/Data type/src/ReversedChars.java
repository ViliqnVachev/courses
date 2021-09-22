import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char first= s.next().charAt(0);
        char second= s.next().charAt(0);
        char third= s.next().charAt(0);

        System.out.print(third);
        System.out.print(second);
        System.out.println(first);
    }
}
