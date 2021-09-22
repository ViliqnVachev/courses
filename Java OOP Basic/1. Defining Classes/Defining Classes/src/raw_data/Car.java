package raw_data;

import java.util.Map;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Map<Integer, Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, Map<Integer, Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getCargoType() {
        return this.cargo.getType();
    }

    public boolean isTireLessThanOne() {

        for (Map.Entry<Integer, Tire> entry : tires.entrySet()) {
            if (entry.getValue().getPressure() < 1) {
                return true;
            }
        }
        return false;
    }

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return this.engine.getPower();
    }
}
