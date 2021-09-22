package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carData = reader.readLine().split("\\s+");
        Vehicles car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        String[] truckData = reader.readLine().split("\\s+");
        Vehicles truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] commands = reader.readLine().split("\\s+");
            String type = commands[0];
            String vehicle = commands[1];
            double distanceOrLitters = Double.parseDouble(commands[2]);

            DecimalFormat df = new DecimalFormat("###.##");
            try {
                switch (type) {
                    case "Drive":
                        if (vehicle.equals("Car")) {
                            car.drive(distanceOrLitters);
                            System.out.println(String.format("Car travelled %s km", df.format(distanceOrLitters)));
                        } else {
                            truck.drive(distanceOrLitters);
                            System.out.println(String.format("Truck travelled %s km", df.format(distanceOrLitters)));
                        }
                        break;
                    case "Refuel":
                        if (vehicle.equals("Car")) {
                            car.refuel(distanceOrLitters);

                        } else {
                            truck.refuel(distanceOrLitters);
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }
        System.out.print(car);
        System.out.println(truck);
    }
}
