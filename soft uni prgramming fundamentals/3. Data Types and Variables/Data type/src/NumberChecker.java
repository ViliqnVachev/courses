import java.util.Scanner;

public class NumberChecker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String number= s.nextLine();

        try{
            long a=Long.parseLong(number);
            System.out.println("integer");
        }catch (Exception ex){
            System.out.println("floating-point");
        }


    }
}
