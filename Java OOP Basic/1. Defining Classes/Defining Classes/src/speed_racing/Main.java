package speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostForKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostForKm);
            if (!cars.containsKey(model)) {
                cars.put(model, car);
            }
        }

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            String model = tokens[1];
            double distance = Double.parseDouble(tokens[2]);

            if (cars.containsKey(model)) {
                if (cars.get(model).canMove(distance)) {
                    cars.get(model).moving(distance);
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }


        cars.entrySet().forEach(c-> System.out.println(c.getValue()) );
    }
}
