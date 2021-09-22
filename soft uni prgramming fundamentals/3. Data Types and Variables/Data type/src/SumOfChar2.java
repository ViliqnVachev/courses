import java.util.Scanner;

public class SumOfChar2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        byte n = Byte.parseByte(s.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            char symbol= s.next().charAt(0);
            sum+=symbol;
        }
        System.out.println("The sum equals: "+sum);
    }
}
