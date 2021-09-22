package deck_of_cards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card> {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.fillTheDeck();
    }

    private void fillTheDeck() {
        for (CardsTypes cardsType : CardsTypes.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardRank, cardsType);
                this.cards.add(card);
            }
        }
    }

    @Override
    public Iterator<Card> iterator() {
        return new CardIterator();
    }

    private final class CardIterator implements Iterator<Card> {
        int index;

        public CardIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return cards.size() != this.index;
        }

        @Override
        public Card next() {
            return cards.get(this.index++);
        }
    }
}
