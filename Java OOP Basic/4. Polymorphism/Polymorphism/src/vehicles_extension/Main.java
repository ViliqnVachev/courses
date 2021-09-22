package vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carData = reader.readLine().split("\\s+");
        Vehicles car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]), Double.parseDouble(carData[3]));

        String[] truckData = reader.readLine().split("\\s+");
        Vehicles truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]), Double.parseDouble(truckData[3]));

        String[] busData = reader.readLine().split("\\s+");
        BusAbstract bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]), Double.parseDouble(busData[3]));
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
                        } else if (vehicle.equals("Truck")) {
                            truck.drive(distanceOrLitters);
                            System.out.println(String.format("Truck travelled %s km", df.format(distanceOrLitters)));
                        } else {
                            bus.drive(distanceOrLitters);
                            System.out.println(String.format("Bus travelled %s km", df.format(distanceOrLitters)));
                        }
                        break;
                    case "Refuel":
                        if (vehicle.equals("Car")) {
                            car.refuel(distanceOrLitters);

                        } else if (vehicle.equals("Truck")) {
                            truck.refuel(distanceOrLitters);
                        } else {
                            bus.refuel(distanceOrLitters);
                        }
                        break;
                    case "DriveEmpty":
                        bus.driveEmpty(distanceOrLitters);
                        System.out.println(String.format("Bus travelled %s km", df.format(distanceOrLitters)));
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        }
        System.out.print(car);
        System.out.print(truck);
        System.out.println(bus);
    }
}
