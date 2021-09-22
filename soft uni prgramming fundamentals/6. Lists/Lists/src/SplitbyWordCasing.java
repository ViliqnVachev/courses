import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SplitbyWordCasing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] allWords = Arrays.stream(s.nextLine().split("[\\\\,:;.!()\"'/\\[\\]\\s]+"))
                .filter(w -> w.length() > 0)
                .toArray(String[]::new);

        List<String> upperCase = new ArrayList<>();
        List<String> lowerCase = new ArrayList<>();
        List<String> mixedCase = new ArrayList<>();

        for (String word : allWords) {
            if (UpperCase(word)) {
                upperCase.add(word);
            } else if (LowerCase(word)) {
                lowerCase.add(word);
            } else {
                mixedCase.add(word);
            }
        }

        System.out.printf("Lower-case: %s%n", String.join(", ", lowerCase));
        System.out.printf("Mixed-case: %s%n", String.join(", ", mixedCase));
        System.out.printf("Upper-case: %s%n", String.join(", ", upperCase));

    }

    static boolean UpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentChar < 'A' || currentChar > 'Z') {
                return false;
            }
        }
        return true;
    }

    static boolean LowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (currentChar < 'a' || currentChar > 'z') {
                return false;
            }
        }
        return true;
    }

}
