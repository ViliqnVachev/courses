package exam_prep_02;

import exam_prep_02.Manager.CarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();

        String line = reader.readLine();
        try {
            while (!"Cops Are Here".equals(line)) {
                String[] tokens = line.split("\\s+");
                String command = tokens[0];
                int carId;
                int raceId;

                switch (command) {
                    case "register":
                        carId = Integer.parseInt(tokens[1]);
                        String type = tokens[2];
                        String brand = tokens[3];
                        String model = tokens[4];
                        int yearOfProduction = Integer.parseInt(tokens[5]);
                        int horsepower = Integer.parseInt(tokens[6]);
                        int acceleration = Integer.parseInt(tokens[7]);
                        int suspension = Integer.parseInt(tokens[8]);
                        int durability = Integer.parseInt(tokens[9]);

                        carManager.register(carId, type, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                        break;

                    case "check":
                        carId = Integer.parseInt(tokens[1]);

                        System.out.println(carManager.check(carId));
                        break;

                    case "open":
                        //int id, String type, int length, String route, int prizePool
                        raceId = Integer.parseInt(tokens[1]);
                        String typeRace = tokens[2];
                        int length = Integer.parseInt(tokens[3]);
                        String route = tokens[4];
                        int prizePool = Integer.parseInt(tokens[5]);

                        carManager.open(raceId, typeRace, length, route, prizePool);
                        break;


                    case "participate":
                        carId = Integer.parseInt(tokens[1]);
                        raceId = Integer.parseInt(tokens[2]);

                        carManager.participate(carId, raceId);
                        break;

                    case "start":
                        raceId = Integer.parseInt(tokens[1]);

                        System.out.println(carManager.start(raceId));
                        break;

                    case "park":
                        carId = Integer.parseInt(tokens[1]);

                        carManager.park(carId);
                        break;
                    case "unpark":
                        carId = Integer.parseInt(tokens[1]);

                        carManager.unpark(carId);
                        break;
                    case "tune":
                        int tuneIndex = Integer.parseInt(tokens[1]);
                        String addOns = tokens[2];

                        carManager.tune(tuneIndex, addOns);
                        break;
                }
                line = reader.readLine();
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
