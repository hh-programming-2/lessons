package lesson5;

import java.util.function.*;

/**
 * The purpose of this example is to illustrate functional programming and
 * lambda functions at a general level. As a comparison to the corresponding
 * object counter from the previous lesson (1+(2*(3+2)))² = 121.
 */
public class FunctionalCalculator {

    public static void main(String[] args) {
        /**
         * Define a lambda function with a single integer parameter and an integer
         * return value
         */
        Function<Integer, Integer> square = x -> x * x;

        // The apply method calls the lambda function with the provided parameter
        int squareOfTwo = square.apply(2);
        System.out.println("2² = " + squareOfTwo);

        /**
         * Define two lambda functions with two integer arguments and an integer return
         * value. BiFunction type of lambda functions have two parameters
         */
        BiFunction<Integer, Integer, Integer> sum = (x1, x2) -> x1 + x2;
        // We can use brackets to implement multi line lambda functions
        BiFunction<Integer, Integer, Integer> mul = (x1, x2) -> {
            return x1 * x2;
        };

        int sumOfNumbers = sum.apply(2, 4);
        System.out.println("2 + 4 = " + sumOfNumbers);

        /**
         * Call the apply function of Function and BiFunction interfaces to execute the
         * lambda function (1+(2*(3+2)))²
         */
        int result = square.apply(
                sum.apply(1, mul.apply(2, sum.apply(3, 2))));

        System.out.println(result);
    }
}
