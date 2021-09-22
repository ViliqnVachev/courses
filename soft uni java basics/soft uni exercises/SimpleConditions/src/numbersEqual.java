import java.util.Scanner;

public class numbersEqual {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);

        int firstNumber=Integer.parseInt(s.nextLine());
        int secondNumber=Integer.parseInt(s.nextLine());
        int thirdNumber=Integer.parseInt(s.nextLine());

        if(firstNumber==secondNumber&&firstNumber==thirdNumber&&secondNumber==thirdNumber){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
