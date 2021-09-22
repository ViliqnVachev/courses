package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends BaseVehicle {

    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price.add(price.multiply(BigDecimal.valueOf(0.5))), (int) (attack + (attack * 1.50)), (int) (defense * 0.5), (int) (hitPoints * 0.5));
    }
}
