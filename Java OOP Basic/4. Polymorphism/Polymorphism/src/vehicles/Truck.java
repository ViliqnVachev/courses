package vehicles;

public class Truck extends Vehicles{
    private static final double ariCondition = 1.6;
    private static final String TRUCK_NEED_REFUELING = "Truck needs refueling";


    private double traveledDistance;

    protected Truck(double fuelQuantity, double pricePerKm) {
        super(fuelQuantity, pricePerKm);
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
        super.setFuelQuantity(super.getFuelQuantity() + fuel*0.95);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Truck: ").append(super.toString());

        return sb.toString();
    }
}
