package raw_data;

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

        List<Car> cars = new ArrayList<>();


        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];

            Tire tire = null;
            int count = 1;
            Map<Integer, Tire> tires = new LinkedHashMap<>();
            for (int j = 4; j < 8; j++) {
                double pressure = Double.parseDouble(tokens[j+count]);
                int tireAge = Integer.parseInt(tokens[j + count+1]);
                tire = new Tire(pressure, tireAge);
                tires.put(count++, tire);
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = reader.readLine();

        switch (command) {
            case "fragile":
                cars.stream().filter(Car::isTireLessThanOne).filter(c -> c.getCargoType().equals("fragile"))
                        .forEach(c -> System.out.println(c.getModel()));
                break;
            case "flamable":
                cars.stream().filter(car -> car.getEnginePower()>250).filter(c -> c.getCargoType().equals("flamable"))
                        .forEach(c -> System.out.println(c.getModel()));
                break;
        }

    }
}
