package google;

public class Car {
    private String model;
    private int speed;

    public Car() {
    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.model == null) {
            sb.append("");
        } else {
            sb.append(String.format("%s %d", this.model, this.speed)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
