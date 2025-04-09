package lesson4;


/**
 * This example illustrates the usage of a simple Shape interface
 */
public class ShapeInterface {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        System.out.println("Circle as string: " + circle);
        System.out.println("Rectangle as string: " + rectangle);

        // isLargerThan and totalPerimeter methods accept any kind of Shape interface object
        System.out.println("Is circle larger?: " + isLargerThan(circle, rectangle));
        System.out.println("Total perimeter: " + totalPerimeter(circle, rectangle));
    }

    public static boolean isLargerThan(Shape a, Shape b) {
        return a.calculateArea() > b.calculateArea();
    }

    public static double totalPerimeter(Shape a, Shape b) {
        return a.calculatePerimeter() + b.calculatePerimeter();
    }
}

interface Shape {
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
        return super.toString() + "Radius: " + radius;
    }

    // Classes that implement a interface can have methods of their own
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
        return super.toString() + "Width: " + width + " Height: " + height;
    }
}
