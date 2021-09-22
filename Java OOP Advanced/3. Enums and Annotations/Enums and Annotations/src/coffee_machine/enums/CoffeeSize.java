package coffee_machine.enums;

public enum CoffeeSize {
    //Small (50 ml, 50 c), Normal (100 ml, 75 c), Double (200 ml, 100 c)

    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int coins;
    private int ml;

    CoffeeSize(int coins, int ml) {
        this.coins = coins;
        this.ml = ml;
    }

    public int getCoins() {
        return coins;
    }

    public int getMl() {
        return ml;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
