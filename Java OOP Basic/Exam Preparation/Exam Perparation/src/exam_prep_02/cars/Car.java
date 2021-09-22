package exam_prep_02.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getEnginePerformancePoints() {
        return (this.horsepower / this.acceleration);
    }

    public int getSuspensionPerformancePoints() {
        return (this.suspension + this.durability);
    }

    public int getOverallPerformancePoints() {
        return this.getEnginePerformancePoints() + this.getSuspensionPerformancePoints();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public abstract void addOns(int index, String addOns);

    public void tuneHorsePower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void tuneSuspension(int suspension) {
        this.suspension = suspension;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d", this.brand, this.model, this.yearOfProduction))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s", this.horsepower, this.acceleration))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability", this.suspension, this.durability));

        return sb.toString();
    }
}
