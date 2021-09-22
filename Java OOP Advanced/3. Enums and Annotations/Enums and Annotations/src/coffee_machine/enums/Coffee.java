package coffee_machine.enums;

public class Coffee {
    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(String coffeeSize, String coffeeType) {
        this.coffeeSize = Enum.valueOf(CoffeeSize.class, coffeeSize.toUpperCase());
        this.coffeeType = Enum.valueOf(CoffeeType.class, coffeeType.toUpperCase());
    }

    public int getPrice() {
        return this.coffeeSize.getCoins();
    }

    @Override
    public String toString() {
        return this.coffeeSize + " " + this.coffeeType;
    }
}
