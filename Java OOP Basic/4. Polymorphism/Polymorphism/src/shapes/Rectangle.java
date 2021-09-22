package shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double sideA, double sideB) {
        this.height = sideA;
        this.width = sideB;
    }

    private double getHeight() {
        return height;
    }

    private double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * (this.getHeight() + this.getWidth()));
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.getHeight() * this.getWidth());
    }
}
