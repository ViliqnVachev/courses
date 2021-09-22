import java.util.Scanner;

public class sumOftwoNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int begin = Integer.parseInt(s.nextLine());
        int end = Integer.parseInt(s.nextLine());
        int maginNumber = Integer.parseInt(s.nextLine());
        int sum = 0;
        int count = 0;
        for (int first = 1; first < end; first++) {
            for (int second = 1; second < begin; second++) {
                sum = first + second;
                count++;
                System.out.print(first);
                System.out.println(first);
               /* if (sum == maginNumber) {
                    System.out.println("Combination N: "+count);
                    System.out.printf("(%d + %d = %d) ",first,second,sum);
                    return;
                }else{
                    System.out.printf("%d Combinations - neither equals %d",count,maginNumber);
                }*/
            }
        }
    }
}
