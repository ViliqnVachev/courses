package fragile_base_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] food) {
        this.foodEaten.addAll((Arrays.asList(food)));
        for (Food food1 : food) {
            this.eat(food1);
        }
    }
}
