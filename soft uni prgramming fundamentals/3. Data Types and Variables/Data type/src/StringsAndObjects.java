import java.util.Scanner;

public class StringsAndObjects {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String one = s.nextLine();
        String two = s.nextLine();
        Object result = one+" "+two ;
        System.out.println(result);
    }
}
