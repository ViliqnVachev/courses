package method_overriding;

public class Square extends Rectangle {
    public Square(double sideA) {
        super(sideA);
    }

    @Override
    protected double area() {
        return this.getSideA() * this.getSideA();
    }
}
