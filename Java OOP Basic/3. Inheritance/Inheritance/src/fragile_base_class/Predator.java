package fragile_base_class;

import java.util.Arrays;

public class Predator extends Animal {
    private int health;

    public void feed(Food food) {
        super.eat(food);
        this.health++;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public void eatAll(Food[] food) {
        for (Food food1 : food) {
            this.feed(food1);
        }
    }
}
