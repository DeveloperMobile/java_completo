package proj2.domain.entities;

import proj2.domain.entities.enums.Color;

public class Circle extends AbstractShape {
    private Double radius;

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
