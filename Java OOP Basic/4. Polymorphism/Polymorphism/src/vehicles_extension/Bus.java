package vehicles_extension;

public class Bus extends BusAbstract {
    private static final double ariCondition = 1.4;
    private static final String TRUCK_NEED_REFUELING = "Bus needs refueling";

    private double traveledDistance;

    protected Bus(double fuelQuantity, double pricePerKm, double tankCapacity) {
        super(fuelQuantity, pricePerKm, tankCapacity);
    }

    @Override
    protected void driveEmpty(double distance) {
        if ((distance * (super.getPricePerKm()) <= super.getFuelQuantity())) {
            this.traveledDistance += distance;
            double fuel = distance * (super.getPricePerKm());
            super.setFuelQuantity(super.getFuelQuantity() - fuel);
        } else {
            throw new IllegalArgumentException(TRUCK_NEED_REFUELING);
        }
    }

    @Override
    protected void drive(double distance) {
        if ((distance * (super.getPricePerKm() + ariCondition) <= super.getFuelQuantity())) {
            this.traveledDistance += distance;
            double fuel = distance * (super.getPricePerKm() + ariCondition);
            super.setFuelQuantity(super.getFuelQuantity() - fuel);
        } else {
            throw new IllegalArgumentException(TRUCK_NEED_REFUELING);
        }
    }

    @Override
    protected void refuel(double fuel) {
        super.refuel(fuel);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bus: ").append(super.toString());

        return sb.toString();
    }
}
