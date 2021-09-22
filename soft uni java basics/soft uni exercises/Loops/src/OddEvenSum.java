import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int evenSum=0;
        int oddSum=0;
        for (int i = 0; i <n ; i++) {
            int number= Integer.parseInt(s.nextLine());
            if(i%2==0){
                evenSum+=number;
            }else{
                oddSum+=number;
            }
        }
        int diff=Math.abs(evenSum-oddSum);
        if(diff==0){
            System.out.printf("Yes\nSum = %d",evenSum);
        }else{
            System.out.printf("No\nDiff = %d",diff);
        }

    }
}
