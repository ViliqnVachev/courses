import java.util.Scanner;

public class EvenorOdd {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number= Integer.parseInt(s.nextLine());

        if(number % 2==0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }
    }
}
