package ferrari;

public class Ferrari implements Car {
    private static final String DEFAULT_MODEL = "488-Spider";

    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
        this.model = DEFAULT_MODEL;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriverName() {
        return this.driver;
    }

    @Override
    public String breaks() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.getModel(), this.breaks(), this.pushGas(), this.getDriverName());
    }
}
