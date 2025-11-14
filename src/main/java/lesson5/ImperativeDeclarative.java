package lesson5;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this example is to demonstrate differences between imperative
 * and declarative programming.
 */
public class ImperativeDeclarative {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> evenNumbersFromForLoop = new ArrayList<>();

        /**
         * Imperative solution: we tell the computer step by step how to achieve the
         * desired outcome
         */
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbersFromForLoop.add(number);
            }
        }

        System.out.println(evenNumbersFromForLoop);

        /**
         * Declarative solution: we describe the result, not the steps, and the
         * underlying system figures out the "how" for us
         */
        List<Integer> evenNumbersFromStream = numbers.stream()
                .filter((number) -> number % 2 == 0)
                .toList();

        System.out.println(evenNumbersFromStream);

        // What does this piece of code do?
        List<Integer> mysteryList = numbers.stream()
                .map((number) -> number * number)
                .toList();

        // System.out.println(mysteryList);
    }
}
