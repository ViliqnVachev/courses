import java.util.Scanner;

public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] alphabet = new char[26];
        String word = s.nextLine();
        char[] charOfWord = word.toCharArray();
        int count = 0;

        for (char letters = 'a'; letters <= 'z'; letters++) {
            alphabet[count] = letters;
            count++;
        }

        for (int j = 0; j < charOfWord.length; j++) {
            for (int i = 0; i < alphabet.length; i++) {
                if (charOfWord[j] == alphabet[i]) {
                    System.out.println(charOfWord[j] + " -> " + i);
                }
            }
        }

    }
}
