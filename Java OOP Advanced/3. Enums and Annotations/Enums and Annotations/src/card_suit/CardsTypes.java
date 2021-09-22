package card_suit;

public enum CardsTypes {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordinal value: ")
                .append(this.ordinal())
                .append("; ")
                .append("Name value: ")
                .append(this.name());

        return sb.toString();
    }
}
