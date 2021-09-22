package shapes_drawing;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Drawable circle = new Circle(5);
        Drawable rect = new Rectangle(5, 10);

        circle.draw();
        rect.draw();

    }
}
