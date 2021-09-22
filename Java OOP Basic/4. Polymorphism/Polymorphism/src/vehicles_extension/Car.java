package vehicles_extension;

public class Car extends Vehicles {
    private static final double ariCondition = 0.9;
    private static final String CAR_NEED_REFUELING = "Car needs refueling";
    private double traveledDistance;

    protected Car(double fuelQuantity, double pricePerKm, double tankCapacity) {
        super(fuelQuantity, pricePerKm, tankCapacity);
    }

    @Override
    protected void drive(double distance) {
        if ((distance * (super.getPricePerKm() + ariCondition) <= super.getFuelQuantity())) {
            this.traveledDistance += distance;
            double fuel = distance * (super.getPricePerKm() + ariCondition);
            super.setFuelQuantity(super.getFuelQuantity() - fuel);
        } else {
            throw new IllegalArgumentException(CAR_NEED_REFUELING);
        }
    }

    @Override
    protected void refuel(double fuel) {
        super.refuel(fuel);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car: ").append(super.toString());

        return sb.toString();
    }
}
