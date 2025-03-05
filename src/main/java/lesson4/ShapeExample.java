package lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This example illustrates the object-oriented programming concepts of Abstract class,
 * super, and instanceof keywords.
 */
public class ShapeExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        System.out.println(": " + circle);
        System.out.println("Rectangle as string: " + rectangle);

        if (circle instanceof Circle) {
            System.out.println("The circle variable is an instance of the Circle class");
        }

        // Different shapes and casting
        AbstractShape aCircle = (AbstractShape) circle;
        AbstractShape aRectangle = (AbstractShape) rectangle;

        int comparisonResult = aCircle.compareTo(aRectangle);
        if (comparisonResult < 0) {
            System.out.println("Circle is smaller than the rectangle");
        } else if (comparisonResult > 0) {
            System.out.println("Circleis larger than the rectangle");
        } else {
            System.out.println("Circle and rectangle have the same size");
        }

        List<AbstractShape> shapes = new ArrayList<>();
        shapes.add(aCircle);
        shapes.add(aRectangle);

        // Let's sort the shapes from smallest to largest using the Collections.sort method
        Collections.sort(shapes);

        System.out.println("Shapes sorted from smallest to largest: ");

        for (AbstractShape shape : shapes) {
            System.out.println(shape.calculateArea());
        }

    }
}

interface Shape {
    double calculateArea();
}

abstract class AbstractShape implements Shape, Comparable<AbstractShape> {
    private int counter;

    public AbstractShape() {
        this.counter = 0;
    }

    protected void increaseCounter() {
        counter++;
    }

    public double calculateArea() {
        increaseCounter();
        return Math.PI;
    }

    public int getCounter() {
        return this.counter;
    }

    @Override
    public String toString() {
        return "Calculated: " + counter + " times. \n\n";
    }

    // Comparable implementation based on the area of the shape
    @Override
    public int compareTo(AbstractShape other) {
        return Double.compare(this.calculateArea(), other.calculateArea());
    }
}

class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        increaseCounter();
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() + "Sade: " + radius;
    }
}

class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        increaseCounter();
        return width * height;
    }

    @Override
    public String toString() {
        return super.toString() + "Width: " + width + " Height: " + height;
    }
}
