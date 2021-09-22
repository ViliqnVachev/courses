import java.util.Scanner;

public class IntervalOfNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a =Integer.parseInt(s.nextLine());
        int b =Integer.parseInt(s.nextLine());

        if(a>b){
            for (int i = b; i <=a ; i++) {
                System.out.println(i);
            }
        }else{
            for (int i = a; i <=b; i++) {
                System.out.println(i);
            }
        }
    }
}
