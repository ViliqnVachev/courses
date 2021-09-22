package shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(2.5);
        Shape rectangle = new Rectangle(3, 5);
        circle.calculateArea();
        rectangle.calculateArea();

        circle.calculatePerimeter();
        rectangle.calculatePerimeter();

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
