package cards_with_power;

import card_compareTo.enums.CardRank;
import card_compareTo.enums.CardsTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String type = reader.readLine();

        CardRank rank1 = CardRank.valueOf(rank);
        CardsTypes types = CardsTypes.valueOf(type);


        int power = rank1.getValue() + types.getValue();

        System.out.printf("Card name: %s of %s; Card power: %d%n", rank1.name(), types.name(), power);
    }
}
