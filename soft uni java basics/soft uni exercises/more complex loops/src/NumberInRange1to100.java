import java.util.Scanner;

public class NumberInRange1to100 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Еnter a number in the range [1...100]: ");
        int n = new Integer(s.nextLine());

        while (n<1 || n>100){
            System.out.println("Invalid number !");
            System.out.print("Еnter a number in the range [1...100]: ");
             n = new Integer(s.nextLine());
        }
        System.out.println("The number is: "+n);
    }
}
