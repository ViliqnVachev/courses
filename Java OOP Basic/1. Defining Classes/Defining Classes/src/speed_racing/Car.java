package speed_racing;

public class Car {
    public static final double DEFAULT_TRAVELED_DISTANCE = 0d;

    private String model;
    private double fuelAmount;
    private double fuelCostForKm;
    private double traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
        this.traveledDistance = DEFAULT_TRAVELED_DISTANCE;
    }

    public boolean canMove(double distance) {
        double temp = distance * this.fuelCostForKm;
        if (temp > this.fuelAmount) {
            return false;
        }

        return true;
    }

    public void moving(double distance) {
        double temp = distance * this.fuelCostForKm;
        this.fuelAmount -= temp;
        this.traveledDistance += distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.traveledDistance);
    }
}
