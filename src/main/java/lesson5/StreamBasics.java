package lesson5;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lesson5.helpers.City;

public class StreamBasics {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1. Using a stream and lambda function to filter out odd numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                // Stream must be "collected", in order it to be "executed", that is evaluated
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers);

        // Example 2. Using a stream and labmda function to transform each number into
        // its square
        List<Integer> squaresOfNumbers = numbers.stream()
                .map(n -> n * n)
                .toList(); // same as collect(Collectors.toList())

        System.out.println("Squares of numbers: " + squaresOfNumbers);

        List<City> cities = List.of(
                new City("Helsinki", 500_000),
                new City("Tampere", 200_000),
                new City("Pori", 70_000));

        // Example 3. Using multiple stream operations
        // to get names of cities with population under 500 000
        List<String> cityNames = cities.stream()
                .filter(city -> city.getPopulation() < 500_000)
                // This is a method reference, same as lambda city -> city.getName()
                .map(City::getName)
                .toList();

        System.out.println("City names with population under 500 000: " + cityNames);

        // Example 4: Reusing streams

        // TODO: Create a stream of large cities (population over 100 000)
        // 1) Get list of names of large cities
        // 2) Get list of populations of large cities

        // Example 5. Using a stream and lambda function to find the maximum number
        int largestNumber = numbers.stream()
                // max collects the maximum value in the stream using a comparator
                .max((numA, numB) -> Integer.compare(numA, numB))
                // It is possible that the stream does not return anything, so the result is of
                // Optional type
                .orElse(0);

        System.out.println("Largest number: " + largestNumber);

        // Exampel 6. Comparison of for loop ja stream implementations
        System.out.println("Sum using for loop = " + countCitiesPopulationUsingForLoop(cities));
        System.out.println("Sum using stream = " + countCititesPopulationUsingStream(cities));

        // Example 7. Using a stream and lambda function to calculate the sum of numbers
        int sum = numbers.stream()
                // Reducer is a function, which reduces the stream into a single value
                // This could also be written as reduce(0, Integer::sum)
                .reduce(0, (total, current) -> total + current);

        System.out.println("Sum of numbers: " + sum);
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
        // Predicate<Boolean> isLargeCity = city -> city.getPopulation() > 100_000;
        // ToIntFunction<City> toPopulation = City::getPopulation;
        return cities.stream()
                .filter(city -> city.getPopulation() > 100_000)
                // This is a method reference, same as lambda city -> city.getPopulation()
                .mapToInt(City::getPopulation)
                .sum();
    }
}
