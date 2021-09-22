import java.util.Scanner;

public class equalWords {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String first=s.nextLine();
        first=first.toLowerCase();
        String second=s.nextLine();
        second=second.toLowerCase();
        if (first.equals(second)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
