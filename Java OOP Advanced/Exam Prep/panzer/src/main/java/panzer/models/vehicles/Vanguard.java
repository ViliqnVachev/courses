package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight * 2, price, (int) (attack - (attack * 0.25)), (int) (defense + (defense * 0.5)), (int) (hitPoints + (hitPoints * 0.75)));
    }
}
