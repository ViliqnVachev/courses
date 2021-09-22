import java.util.Scanner;

public class CountTheIntegers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count=0;

        try{
            for (int i = 0; i <100 ; i++) {
                int n =Integer.parseInt(s.nextLine());
                    count++;
            }

        }
        catch (Exception ex){
            System.out.println(count);
                return;
        }
    }
}
