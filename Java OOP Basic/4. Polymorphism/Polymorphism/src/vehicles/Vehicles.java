package vehicles;

public abstract class Vehicles {
    private double fuelQuantity;
    private double pricePerKm;

    protected Vehicles(double fuelQuantity, double pricePerKm) {
        this.fuelQuantity = fuelQuantity;
        this.pricePerKm = pricePerKm;
    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    protected double getPricePerKm() {
        return pricePerKm;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected abstract void drive(double distance);

    protected abstract void refuel(double fuel);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%.2f", this.fuelQuantity)).append(System.lineSeparator());

        return sb.toString();
    }
}
