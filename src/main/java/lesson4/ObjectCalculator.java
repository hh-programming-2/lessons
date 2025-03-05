package lesson4;

/**
 * We calculate the expression (1+(2*(3+2))) = 11 using an object-oriented counter
 * modeled according to object modeling. The purpose is to illustrate the polymorphism
 * of objects and object modeling, and to provide a comparison to other paradigms.
 * It is also noteworthy that this implementation does not contain any if statements
 * or for-loops, unlike the imperative implementation. This also shows that modeling
 * the problem as objects produces quite a lot of lines of code.
 * 
 * See also: ImperativeCounter.java
 */
public class ObjectCalculator {

    public static void main(final String[] args) {
        // This solution is an example of "declarative programming"
        // In imperative programming we tell the computer how to do things,
        // whereas in declarative declarative programming, we focus on what we want to get from the computer
        int result = new Sum(new Id(1), new Mul(new Id(2), (new Sum(new Id(3), new Id(2))))).calculate();
        System.out.println("Result = " + result);

        // Another example of declarative programming is SQL: "SELECT name FROM Person WHERE age >= 18"
    }
}

interface Operation {
    public int calculate();
}

class Sum implements Operation {

    private Operation x1, x2;

    public Sum(Operation x1, Operation x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int calculate() {
        return x1.calculate() + x2.calculate();
    }

}

class Mul implements Operation {

	private Operation x1, x2;

    public Mul(Operation x1, Operation x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int calculate() {
        return x1.calculate() * x2.calculate();
    }

}

class Id implements Operation {

	private int x1;

    public Id(int x1) {
        this.x1 = x1;
    }

    @Override
    public int calculate() {
        return x1;
    }

}
