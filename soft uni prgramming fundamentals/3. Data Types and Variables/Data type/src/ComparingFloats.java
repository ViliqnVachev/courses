import java.util.Scanner;

public class ComparingFloats {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double first = Double.parseDouble(s.nextLine());
        double second = Double.parseDouble(s.nextLine());
        double eps = 0.000001;

        if(Math.abs(first-second)<eps){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
