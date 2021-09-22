package coffee_machine;

import coffee_machine.enums.Coffee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String line = reader.readLine();
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (!"END".equals(line)) {

            String[] tokens = line.split("\\s+");

            switch (tokens.length) {
                case 2:
                    coffeeMachine.buyCoffee(tokens[0], tokens[1]);
                    break;
                default:
                    coffeeMachine.insertCoin(tokens[0]);
                    break;
            }

            line = reader.readLine();
        }

        Iterable<Coffee>coffees=coffeeMachine.coffeesSold();

        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }
    }
}
