package lesson5;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lesson5.helpers.City;

public class BasicFunctionalExamples {

    public static void main(String[] args) {

        List<City> cities = List.of(
                new City("Helsinki", 500_000),
                new City("Tampere", 200_000),
                new City("Pori", 70_000));

        // Exampel 1. Comparison of for loop ja stream implementations
        System.out.println("Sum using for loop = " + countCitiesPopulationUsingForLoop(cities));
        System.out.println("Sum using stream = " + countCititesPopulationUsingStream(cities));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 2. Using a stream and lambda function to filter out odd numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList()); // Stream must be "collected", in order it to be "executed", that is
                                               // evaluated

        System.out.println("Even numbers: " + evenNumbers);

        // Example 3. Using a stream and labmda function to transform each number into
        // its square
        List<Integer> squaresOfNumbers = numbers.stream()
                .map(n -> n * n)
                .toList(); // same as collect(Collectors.toList())

        System.out.println("Squares of numbers: " + squaresOfNumbers);

        // Example 4. Using a stream and lambda function to find the maximum number
        int largestNumber = numbers.stream()
                // Method reference syntax using the :: operator
                .max(Integer::compareTo) // In an IntegerStream there are special methods such as max
                .orElse(0); // It is possible that the stream does not return anything, so the result is of
                            // Optional type

        System.out.println("Largest number: " + largestNumber);

        // Example 5. Providing a lambda function as parameter for another function
        // In this case the function prints the square of each number
        customForEach(numbers, n -> System.out.println("Neliö: " + (n * n)));

        // Example 6. Using a stream and lambda function to calculate the sum of numbers
        int sum = numbers.stream()
                // Reducer is a function, which reduces the stream into a single value
                // This could also be written as reduce(0, Integer::sum)
                .reduce(0, (total, current) -> total + current);

        System.out.println("Sum of numbers: " + sum);
    }

    // Example of a function, which accepts another function as parameter
    private static void customForEach(List<Integer> numbers, Consumer<Integer> consumerFunction) {
        for (Integer number : numbers) {
            // The accept method calls the consumer function
            consumerFunction.accept(number);
        }

        // We could also use the List.forEach method
        // numbers.forEach(consumerFunction);
    }

    private static int countCitiesPopulationUsingForLoop(List<City> cities) {
        int sum = 0;
        for (City city : cities) {
            int population = city.getPopulation();
            if (population > 100_000) {
                sum += population;
            }
        }
        return sum;
    }

    private static int countCititesPopulationUsingStream(List<City> cities) {
        // The types of the lambda functions are displayed below
        // (https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html)
        // Predicate<Boolean> isLargeCity = city -> cities.get(0).getPopulation() >
        // 100_000;
        // ToIntFunction<City> toPopulation = City::getPopulation;
        return cities.stream()
                .filter((City city) -> {
                    return city.getPopulation() > 100_000;
                })
                .mapToInt(City::getPopulation) // Double colon method reference
                                               // (https://www.geeksforgeeks.org/double-colon-operator-in-java/)
                .sum();
    }
}
