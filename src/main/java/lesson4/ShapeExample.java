package lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tämä esimerkki havainnollistaa olio-ohjelmoinnin käsitteitä Abstrakti-luokka,
 * super- ja instanceof
 * -avainsanat.
 */
public class ShapeExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Ympyrän pinta-ala: " + circle.calculateArea());
        System.out.println("Suorakulmion pinta-ala: " + rectangle.calculateArea());

        System.out.println("Ympyrä tulostettuna: " + circle);
        System.out.println("Suorakulmio tulostettuna: " + rectangle);

        if (circle instanceof Circle) {
            System.out.println("Ympyrä on todella ympyrä");
        }

        // Verrataan muotoja, myös olioiden castaus
        AbstractShape aYmpyra = (AbstractShape) Circle;
        AbstractShape aSuorakulmio = (AbstractShape) Rectangle;

        int comparisonResult = aYmpyra.compareTo(aSuorakulmio);
        if (comparisonResult < 0) {
            System.out.println("Ympyrä on pienempi kuin Suorakulmio.");
        } else if (comparisonResult > 0) {
            System.out.println("Ympyrä on suurempi kuin Suorakulmio.");
        } else {
            System.out.println("Ympyrä ja Suorakulmio ovat saman kokoisia.");
        }

        List<AbstractShape> muodot = new ArrayList<>();
        muodot.add(aYmpyra);
        muodot.add(aSuorakulmio);

        // Järjestetään Collections.sort:in avulla pienimmästä suurimpaan
        Collections.sort(muodot);

        System.out.println("Muodot järjestyksessä: ");

        for (AbstractShape muoto : muodot) {
            System.out.println(muoto.calculateArea());
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
        return "Laskettu: " + counter + " kertaa. \n\n";
    }

    // Comparable toteutus pinta-alan perusteella
    @Override
    public int compareTo(AbstractShape other) {
        return Double.compare(this.calculateArea(), other.calculateArea());
    }
}

class Circle extends AbstractShape {
    private double sade;

    public Circle(double sade) {
        super();
        this.sade = sade;
    }

    @Override
    public double calculateArea() {
        increaseCounter();
        return Math.PI * sade * sade;
    }

    @Override
    public String toString() {
        return super.toString() + "Sade: " + sade;
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
