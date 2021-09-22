package exam_prep_02.Manager;

import exam_prep_02.Garage.Garage;
import exam_prep_02.cars.Car;
import exam_prep_02.cars.PerformanceCar;
import exam_prep_02.cars.ShowCar;
import exam_prep_02.races.CasualRace;
import exam_prep_02.races.DragRace;
import exam_prep_02.races.DriftRace;
import exam_prep_02.races.Race;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    //complete
    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        if (!this.cars.containsKey(id)) {
            Car car = null;
            switch (type) {
                case "Performance":
                    car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                    break;
                case "Show":
                    car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                    break;
            }

            if (car != null) {
                this.cars.put(id, car);
            }
        }
    }

    //complete
    public String check(int id) {
        return this.cars.get(id).toString();
    }

    //complete;
    public void open(int id, String type, int length, String route, int prizePool) {
        if (!this.races.containsKey(id)) {
            Race race = null;

            switch (type) {
                case "Casual":
                    race = new CasualRace(length, route, prizePool);
                    break;
                case "Drag":
                    race = new DragRace(length, route, prizePool);
                    break;
                case "Drift":
                    race = new DriftRace(length, route, prizePool);
                    break;
            }
            if (race != null) {
                this.races.put(id, race);
            }
        }
    }

    //Maybe Problem
    public void participate(int carId, int raceId) {
        if (this.cars.containsKey(carId) && this.races.containsKey(raceId)) {
            Car car = this.cars.get(carId);
            Race race = this.races.get(raceId);
            if (!this.garage.hasCar(car) && !race.hasParticipantCar(car)) {
                race.addParticipant(car);
            }
        }
    }

    public String start(int id) {
        StringBuilder sb = new StringBuilder();

        Race race = this.races.get(id);
        this.races.remove(id);
        sb.append(String.format("%s - %s", race.getRout(), race.getLength()));
        if (race.hasParticipant()) {
            sb.append(race.toString());
            return sb.toString();
        } else {
            return "Cannot start the race with zero participants.";
        }

    }

    //Maybe Problem
    public void park(int carId) {
        if (this.cars.containsKey(carId)) {
            Car car = this.cars.get(carId);

            for (Map.Entry<Integer, Race> raceEntry : races.entrySet()) {
                if (raceEntry.getValue().hasParticipantCar(car)) {
                    return;
                }
            }
            this.garage.addCartToGarage(car);
        }
    }

    //Maybe Problem
    public void unpark(int carId) {
        if (this.cars.containsKey(carId)) {
            Car car = this.cars.get(carId);

            this.garage.removeCarFormTheGarage(car);
        }
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.tune(tuneIndex, addOn);
    }

}
