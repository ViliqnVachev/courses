package card_compareTo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String rank = reader.readLine();
        String type = reader.readLine();

        Card card1 = new Card(rank, type);

        rank = reader.readLine();
        type = reader.readLine();

        Card card2 = new Card(rank, type);

        Card greater = card1.compareTo(card2)>0?card1:card2;
        System.out.println(greater);
    }
}
