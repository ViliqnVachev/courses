package vehicles_extension;

public abstract class BusAbstract extends Vehicles {
    protected BusAbstract(double fuelQuantity, double pricePerKm, double tankCapacity) {
        super(fuelQuantity, pricePerKm, tankCapacity);
    }

    protected abstract void driveEmpty(double distance);


}
