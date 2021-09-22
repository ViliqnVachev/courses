package card_compareTo;


import card_compareTo.enums.CardRank;
import card_compareTo.enums.CardsTypes;

public class Card implements Comparable<Card> {
    private CardRank rank;
    private CardsTypes types;


    public Card(String rank, String types) {
        this.rank = Enum.valueOf(CardRank.class, rank);
        this.types = Enum.valueOf(CardsTypes.class, types);

    }

    public int setPower() {
        return this.rank.getValue() + this.types.getValue();
    }

    @Override
    public String toString() {
        //Card name: TWO of CLUBS; Card power: 2

        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.types, this.setPower());
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.setPower(), o.setPower());
    }
}
