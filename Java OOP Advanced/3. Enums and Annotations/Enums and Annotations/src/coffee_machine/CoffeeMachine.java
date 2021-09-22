package coffee_machine;

import coffee_machine.enums.Coffee;
import coffee_machine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffees;
    private int money;

    public CoffeeMachine() {
        this.coffees = new ArrayList<>();
        this.money = 0;
    }

    public void buyCoffee(String size, String type) {
        Coffee coffee = new Coffee(size, type);
        if (this.money >= coffee.getPrice()) {
            this.coffees.add(coffee);
            this.money = 0;
        }
    }

    public void insertCoin(String coin) {
        this.money += Enum.valueOf(Coin.class, coin.toUpperCase()).getValue();

    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffees;
    }

}
