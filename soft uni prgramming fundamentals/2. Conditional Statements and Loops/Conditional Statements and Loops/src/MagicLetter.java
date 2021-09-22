import java.util.Scanner;

public class MagicLetter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String first=s.nextLine();
        char firstChar= first.charAt(0);
        String second=s.nextLine();
        char secondChar=second.charAt(0);
        String third=s.nextLine();
        char thirdChar=third.charAt(0);

        for (char i = firstChar; i <=secondChar ; i++) {
            for (char j = firstChar; j <=secondChar ; j++) {
                for (char k = firstChar; k <=secondChar ; k++) {
                    if(i!=thirdChar && j!=thirdChar && k!=thirdChar)
                    System.out.printf("%s%s%s ",i,j,k);
                }
            }
        }
    }
}
