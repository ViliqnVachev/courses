import java.util.Scanner;

public class NumbersSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int begin=Integer.parseInt(s.nextLine());
        int end =Integer.parseInt(s.nextLine());
        int magicNumber =Integer.parseInt(s.nextLine());
        int sum=0;
        int count=0;
        int count2=0;

        for (int row = begin; row >=end; row--) {
            for (int col = begin; col >= end; col--) {
                count++;

                sum=row+col;
                if(sum==magicNumber){
                    System.out.printf("Combination N:%d (%d + %d = %d) ",count,row,col,magicNumber);
                    return;
                }
                }

        //System.out.printf("%d %d%n",row,col);
            }
        for (int row = begin; row >=end; row--) {
            for (int col = begin; col >= end; col--) {
                count++;

                sum=row+col;
                if(sum!=0){
                    System.out.printf("%d combinations - neither equals %d",count-1,magicNumber);
                    return;
                }
            }

            //System.out.printf("%d %d%n",row,col);
        }
        }
    }

