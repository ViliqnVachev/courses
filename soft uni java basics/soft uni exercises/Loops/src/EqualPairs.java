import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int sum = 0;
        int diff = 0;
        int sum2=0;
        for (int i = 1; i <2* n; i++) {
        if(i==1){
            int firstNumber=Integer.parseInt(s.nextLine());
            int secondNumber=Integer.parseInt(s.nextLine());
            sum=firstNumber+secondNumber;
            }else{
            int firstNumber1=Integer.parseInt(s.nextLine());
            int firstNumber2=Integer.parseInt(s.nextLine());

            diff=sum2-sum2;
            sum2=firstNumber2+firstNumber1;

        }

        }
        if (diff > 0)
        {
            System.out.println("No, maxdiff=" + diff);
        }
        else
        {
            System.out.println("Yes, value=" + sum2);
        }

    }
}
