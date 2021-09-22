package vehicles_extension;

public abstract class Vehicles {
    private static final String INVALID_TANK_CAPACITY = "Fuel must be a positive number";
    private static final String INVALID_REFUELING = "Cannot fit fuel in tank";

    private double fuelQuantity;
    private double pricePerKm;
    private double tankCapacity;

    protected Vehicles(double fuelQuantity, double pricePerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setPricePerKm(pricePerKm);
        this.setTankCapacity(tankCapacity);
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected double getPricePerKm() {
        return pricePerKm;
    }

    private void setPricePerKm(double pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    protected double getTankCapacity() {
        return tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        if (tankCapacity < 0) {
            throw new IllegalArgumentException(INVALID_TANK_CAPACITY);
        }
        this.tankCapacity = tankCapacity;
    }

    protected void refuel(double fuel) {
        if (fuel + this.getFuelQuantity() > this.getTankCapacity()) {
            throw new IllegalArgumentException(INVALID_REFUELING);
        } else if (fuel <= 0) {
            throw new IllegalArgumentException(INVALID_TANK_CAPACITY);
        }
        this.setFuelQuantity(fuel + this.getFuelQuantity());
    }

    protected abstract void drive(double distance);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.2f", this.fuelQuantity)).append(System.lineSeparator());

        return sb.toString();
    }
}
