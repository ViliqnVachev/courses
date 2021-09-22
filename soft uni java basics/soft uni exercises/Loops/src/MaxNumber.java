import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int maxNumber=Integer.MIN_VALUE;

        for (int i = 0; i <n ; i++) {
            int number=Integer.parseInt(s.nextLine());
            if(number>maxNumber){
                maxNumber=number;
            }

        }
        System.out.println(maxNumber);
    }
}
