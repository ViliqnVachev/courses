package card_suit;

public class Main {
    public static void main(String[] args) {
        CardsTypes[] cardsTypes = CardsTypes.values();

        System.out.println("Card Suits:");
        for (CardsTypes cardsType : cardsTypes) {
            System.out.println(cardsType);
        }
    }
}
