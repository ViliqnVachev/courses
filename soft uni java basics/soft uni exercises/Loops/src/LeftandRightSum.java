import java.util.Scanner;

public class LeftandRightSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        int leftSum=0;
        int rightSum=0;
        for (int i = 0; i <2*n; i++) {
            int number= Integer.parseInt(s.nextLine());
            if(i>=n){
                leftSum+=number;
            }else{
                rightSum+=number;
            }
        }
        int diff=Math.abs(leftSum-rightSum);
        if(diff==0){
            System.out.printf("Yes, sum = %d",leftSum);
        }else {
            System.out.printf("No, diff = %d",diff);
        }
    }
}
