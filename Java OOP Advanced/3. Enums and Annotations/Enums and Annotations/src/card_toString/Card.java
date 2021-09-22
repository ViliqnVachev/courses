package card_toString;


import card_toString.enums.CardRank;
import card_toString.enums.CardsTypes;

public class Card {
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
}
