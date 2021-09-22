import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        int maxNumber=Integer.MIN_VALUE;
        int sum=0;

        for (int i = 0; i <n ; i++) {
            int number= Integer.parseInt(s.nextLine());
            if(number>maxNumber){
                maxNumber=number;
            }
            sum+=number;
        }
        sum-=maxNumber;
        int diff=Math.abs(sum-maxNumber);
        if(sum==maxNumber){
            System.out.printf("Yes\nSum = %d",sum);
        }else{
            System.out.printf("No\nDiff = %d",diff);
        }
    }
}
