package coffee_machine.enums;

public enum Coin {
    //1, 2, 5, 10, 20, 50
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
