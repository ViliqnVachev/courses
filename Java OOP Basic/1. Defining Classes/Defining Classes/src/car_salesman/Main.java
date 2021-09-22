package car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int engineNumbers = Integer.parseInt(reader.readLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < engineNumbers; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);

            Engine engine = null;

            switch (tokens.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        int displacement = Integer.parseInt(tokens[2]);
                        engine = new Engine(model, power, displacement);
                    } else {
                        String efficiency = tokens[2];
                        engine = new Engine(model, power, efficiency);
                    }
                    break;
                case 4:
                    int displacement = Integer.parseInt(tokens[2]);
                    String efficiency = tokens[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;
            }
            engines.putIfAbsent(tokens[0], engine);
        }

        int carNumbers = Integer.parseInt(reader.readLine());
        for (int i = 0; i < carNumbers; i++) {
            String[] tokens = reader.readLine().split(" ");

            Car car = null;
            switch (tokens.length) {
                case 2:
                    car = new Car(tokens[0], engines.get(tokens[1]));
                    break;
                case 3:
                    if (tokens[2].matches("\\d+")) {
                        int weight = Integer.parseInt(tokens[2]);
                        car = new Car(tokens[0], engines.get(tokens[1]), weight);
                    } else {
                        String color = tokens[2];
                        car = new Car(tokens[0], engines.get(tokens[1]), color);
                    }
                    break;
                case 4:
                    car = new Car(tokens[0], engines.get(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
                    break;
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
