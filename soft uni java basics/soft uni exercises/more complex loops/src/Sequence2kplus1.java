import java.util.Scanner;

public class Sequence2kplus1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =Integer.parseInt(s.nextLine());

            int num = 1;
        boolean b= true;

        while (b){
            if(num<=n){
                System.out.println(num);
            num =num*2+1;
            }else{
                b=false;
            }
        }

    }
}
