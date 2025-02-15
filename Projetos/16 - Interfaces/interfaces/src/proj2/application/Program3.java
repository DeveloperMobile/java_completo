package proj2.application;

import proj2.domain.entities.Circle;
import proj2.domain.entities.Rectangle;
import proj2.domain.entities.Shape;
import proj2.domain.entities.enums.Color;

public class Program3 {
    public static void main(String[] args) {
        Shape s1 = new Circle(Color.BLACK, 2.0);
        Shape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);

        System.out.println("Circle color: " + s1.getColor());
        System.out.println("Circle area: " + String.format("%.2f", s1.area()));
        System.out.println("Rectangle color: " + s2.getColor());
        System.out.println("Rectangle area: " + String.format("%.2f", s2.area()));
    }
}
