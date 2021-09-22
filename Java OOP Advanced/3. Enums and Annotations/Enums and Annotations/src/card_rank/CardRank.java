package card_rank;

public enum CardRank {

    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

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
