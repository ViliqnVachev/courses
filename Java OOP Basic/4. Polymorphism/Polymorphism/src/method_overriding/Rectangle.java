package method_overriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    protected Rectangle(double sideA) {
        this.sideA = sideA;
    }

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    protected double area() {
        return this.sideA * this.sideB;
    }

    protected double getSideA() {
        return sideA;
    }
}
