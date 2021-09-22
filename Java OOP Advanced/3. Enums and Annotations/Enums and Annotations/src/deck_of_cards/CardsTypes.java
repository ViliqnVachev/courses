package deck_of_cards;

public enum CardsTypes {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private int value;

    CardsTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
