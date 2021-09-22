package deck_of_cards;


public class Card {
    private CardRank rank;
    private CardsTypes types;


    public Card(CardRank rank, CardsTypes types) {
        this.rank = rank;
        this.types = types;

    }

    public int setPower() {
        return this.rank.getValue() + this.types.getValue();
    }

    @Override
    public String toString() {
//ACE of CLUBS
        return String.format("%s of %s", this.rank, this.types);
    }
}
