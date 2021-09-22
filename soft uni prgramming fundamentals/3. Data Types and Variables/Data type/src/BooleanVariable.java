import java.util.Scanner;

public class BooleanVariable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        boolean b = Boolean.parseBoolean(a);
        if(b){

            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
