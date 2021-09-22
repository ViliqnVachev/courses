import java.util.Scanner;

public class GameOfNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int firstNumber=Integer.parseInt(s.nextLine());
        int secondNumber=Integer.parseInt(s.nextLine());
        int number=Integer.parseInt(s.nextLine());
        int count=0;
        for (int i = secondNumber; i >=firstNumber  ; i--) {
            for (int j = secondNumber; j >=firstNumber ; j--) {
               if(i+j==number){
                   System.out.printf("Number found! %d + %d = %d",i,j,number);
                return;
               }else{
                   count++;
               }
            }
        }
        System.out.printf("%d combinations - neither equals %d",count,number);
    }
}
