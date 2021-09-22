import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int minNumber= Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(s.nextLine());
            if(number<minNumber){
                minNumber=number;
            }
        }
        System.out.println(minNumber);
    }
}
