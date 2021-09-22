import java.util.Scanner;

public class TriplesOfLetters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =Integer.parseInt(s.nextLine());
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < n ; k++) {
                    char letter =(char)('a'+i);
                    char letter2 =(char)('a'+j);
                    char letter3 =(char)('a'+k);

                    System.out.printf("%c%c%c %n", letter, letter2, letter3);
                }
            }
        }
    }
}
