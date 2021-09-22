import java.util.Scanner;

public class EvenPowersof2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        for (int i = 0; i <= n; i+=2) {
            System.out.println((int)Math.pow(2,i));
        }
    }}
