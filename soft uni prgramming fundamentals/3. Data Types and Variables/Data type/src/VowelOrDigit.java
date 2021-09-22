import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
     char symbol =s.next().charAt(0);
        if (symbol == 'a' || symbol == 'e'|| symbol=='o' || symbol=='y' ||symbol=='u' || symbol=='i') {
            System.out.println("vowel");
        }else if (symbol>='0'&&symbol<='9'){
            System.out.println("digit");
        }else{
            System.out.println("other");
        }
    }
}
