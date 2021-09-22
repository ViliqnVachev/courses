package fragile_base_class;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Food[] food = new Food[]{
                new Food(),
                new Food(),
                new Food()
        };
        Predator predator = new Predator();
        predator.eatAll(food);


        System.out.println(predator.getHealth());

    }
}
