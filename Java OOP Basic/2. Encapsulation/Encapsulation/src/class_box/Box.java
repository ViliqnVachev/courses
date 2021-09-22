package class_box;

public class Box {
    private double length;
    private double width;
    private double height;
    private double volume;
    private double surfaceArea;
    private double lateralSurfaceArea;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void setVolume() {
        this.volume = this.length * this.height * this.width;
    }

    public void setSurfaceArea() {
        this.surfaceArea = 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public void setLateralSurfaceArea() {
        this.lateralSurfaceArea = 2 * this.length * this.height + 2 * this.width * this.height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Surface Area - %.2f", this.surfaceArea)).append(System.lineSeparator())
                .append(String.format("Lateral Surface Area - %.2f", this.lateralSurfaceArea)).append(System.lineSeparator())
                .append(String.format("Volume - %.2f", this.volume)).append(System.lineSeparator());
        return sb.toString();
    }
}
