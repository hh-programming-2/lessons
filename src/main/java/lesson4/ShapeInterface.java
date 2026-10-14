package lesson4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This example illustrates the usage of a simple Shape interface
 */
public class ShapeInterface {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        // Note that we can't create an instance of an interface!
        // Shape randomShape = new Shape();
        // List of objects implementing the Shape interface
        List<Shape> shapes = List.of(circle, rectangle);

        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        System.out.println("Circle as string: " + circle);
        System.out.println("Rectangle as string: " + rectangle);

        // isLargerThan and totalPerimeter methods accept any kind of Shape interface object
        System.out.println("Is circle larger?: " + isLargerThan(circle, rectangle));
        System.out.println("Total perimeter: " + totalPerimeter(shapes));

        // List is a built-in interface in Java, with methods such as add, get and remove
        // Both ArrayList and LinkedList implement the List interface
        List<String> arrayList = new ArrayList<>();
        arrayList.add("ArrayList item");
        List<String> linkedList = new LinkedList<>();
        linkedList.add("LinkedList item");
    }

    // We don't need to know the exact class of the shape; it is enough that it implements the Shape interface
    // => The method becomes much more reusable in the code
    public static boolean isLargerThan(Shape a, Shape b) {
        return a.calculateArea() > b.calculateArea();
    }

    public static double totalPerimeter(List<Shape> shapes) {
        double total = 0;

        for(Shape shape : shapes) {
            total += shape.calculatePerimeter();
        }

        return total;
    }
}

// The Shape interface specifies common methods for all shapes (circle, rectangle, triangle, etc.)
interface Shape {
    // Note that interfaces don't have attributes or a constructor!
    
    // Class that implements this Shape interface needs to provide implementation for ALL of its methods!
    double calculateArea();
    double calculatePerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Radius: " + radius;
    }

    // Classes that implement an interface can have methods of their own
    public double getDiameter() {
        return 2 * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public String toString() {
        return "Width: " + width + " Height: " + height;
    }
}
