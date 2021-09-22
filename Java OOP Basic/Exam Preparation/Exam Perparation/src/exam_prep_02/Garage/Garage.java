package exam_prep_02.Garage;

import exam_prep_02.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public boolean hasCar(Car car) {
        return this.parkedCars.contains(car);
    }

    public void addCartToGarage(Car car) {
        this.parkedCars.add(car);
    }

    public void removeCarFormTheGarage(Car car) {
        if (this.hasCar(car)) {
            this.parkedCars.remove(car);
        }
    }

    public void tune(int tuneIndex, String addOns) {
        for (Car car : parkedCars) {
            switch (car.getClass().getSimpleName()) {
                case "PerformanceCar":
                    int horsePower = car.getHorsepower() + tuneIndex;
                    car.tuneHorsePower(horsePower);
                    int suspension = car.getSuspension() + tuneIndex / 2;
                    car.tuneSuspension(suspension);
                    car.addOns(tuneIndex, addOns);
                    break;
                case "ShowCar":
                    car.setHorsepower(car.getHorsepower() + tuneIndex);
                    car.setSuspension(car.getSuspension() + tuneIndex / 2);
                    car.addOns(tuneIndex, addOns);
                    break;
            }
        }

    }
}
