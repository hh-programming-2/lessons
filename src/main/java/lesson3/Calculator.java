package lesson3;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public String addWithCurrency(int a, int b) {
        return (a + b) + " €";
    }

    /*
     * Calculate factorial of the given integer. Factorial of a negative
     * integer should be 1.
     * 
     * Examples:
     * factorial(-1) = 1
     * factorial(0) = 1
     * factorial(1) = 1
     * factorial(3) = 1 * 2 * 3 = 6
     * factorial(4) = 1 * 2 * 3 * 4 = 24
     */
    public int factorial(int a) {
        // TODO
        return -1;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("5/2 = " + calc.divide(5, 2));
    }
}
