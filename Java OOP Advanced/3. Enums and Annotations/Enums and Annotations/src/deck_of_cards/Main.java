package deck_of_cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Deck deck = new Deck();

        if ("Card Deck".equals(input)) {
            for (Card card : deck) {
                System.out.println(card);
            }
        }
    }
}
