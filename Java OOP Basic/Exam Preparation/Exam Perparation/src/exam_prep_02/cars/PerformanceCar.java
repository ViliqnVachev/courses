package exam_prep_02.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;


    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void addOns(int index, String addOns) {
        this.addOns.add(addOns);
    }

    @Override
    public void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + ((horsepower * 50) / 100));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension(suspension - ((suspension * 25) / 100));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString()).append(System.lineSeparator());

        String addOns = this.addOns.size() == 0 ? "None" : String.join(", ", this.addOns);

        sb.append(String.format("Add-ons: %s", addOns));

        return sb.toString();
    }
}
