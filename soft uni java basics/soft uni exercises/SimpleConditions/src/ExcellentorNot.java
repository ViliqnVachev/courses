import java.util.Scanner;

public class ExcellentorNot {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double grade=Double.parseDouble(s.nextLine());

        if(grade >= 5.50){
            System.out.println("Excellent!");
        }else{
            System.out.println("Not excellent.");
        }
    }
}
