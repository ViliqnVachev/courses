import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a=Integer.parseInt(s.nextLine());
        int b=Integer.parseInt(s.nextLine());

        if (a>b){
            System.out.println("Greater number: "+a);
        }else{
            System.out.println("Greater number: "+b);
        }
    }
}
