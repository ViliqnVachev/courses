package ferrari;

public class Ferrari implements Vechicle {
    private String model;
    private String driverName;

    public Ferrari(String driverName) {
        this.model = "488-Spider";
        this.driverName = driverName;
    }

    @Override
    public String useBreaks() {
        return "Brakes!";
    }

    @Override
    public String useGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }
}
