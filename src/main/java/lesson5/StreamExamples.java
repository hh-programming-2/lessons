package lesson5;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

import lesson5.helpers.Person;

public class StreamExamples {

    public static void main(String[] args) {
        List<String> carBrands = List.of("Volvo", "BMW", "Mersu", "Volvo");
        
        List<Person> persons = List.of(
            new Person("Liisa", 25),
            new Person("Ville", 30),
            new Person("Kalle", 22),
            new Person("Taina", 28),
            new Person("Jere", 15)
        );
        
        // Example 1: 
        List<Integer> lengths = getLengthsOfStrings(carBrands);
        System.out.println("Lengths of strings: " + lengths);

        // Example 2:
        Optional<Person> maybePerson = findByName(persons, "Ville");
        maybePerson.ifPresent(h -> System.out.println("Found: " + h));
        
        // Example 3:
        double averageAge = getAverageAge(persons, 18);
        System.out.println("Average age of persons: " + averageAge);
        
        // Example 4: 
        Map<String, Long> stringCountMap = countOccurences(carBrands);
        stringCountMap.forEach((key, value) -> System.out.println(key + ": " + value));
        
        // Example 5:
        // <ul>
        //   <li>Name: Pekka, Age: 21</li>
        //   <li>Name: Maija, Age: 19</li>
        // </ul>
        String htmlList = createHtmlList(persons);
        System.out.println("HTML list:\n" + htmlList);
    }

    // Example 1: Usage of streams and lambdas to get the lengths of strings
    public static List<Integer> getLengthsOfStrings(List<String> strings) {
        return strings.stream()
                .map(String::length)
                // Collect the results using the Collectors.toList method
                .collect(Collectors.toList()); 
    }
    
    // Example 2: Find person by name. Return value is a Optional<Person>, because person might not be found
    public static Optional<Person> findByName(List<Person> persons, String name) {
        /*for (Person person : persons) {
            if (person.getNimi().equals(name)) {
                return Optional.of(person); // Found the person, wrap it into an Optional
            }
        }
        return Optional.empty();*/ // Not found, return an empty Optional
   
	    return persons.stream()
	            .filter(person -> person.name().equalsIgnoreCase(name))
	            .findFirst();
    }

    // Example 3: Using streams, lambdas and Optional class to calculate the average age of persons
    public static double getAverageAge(List<Person> persons, int lowestAge) {
        OptionalDouble maybeAverage = persons.stream() // average method returns a OptionalDouble object
                .filter(person -> person.age() > lowestAge) // Lambda functions filters out persons below the lowestAge limit
        		.mapToDouble(person -> person.age()) // Here we could also use a method reference Person::getAge
                .average(); // The average method is available in the DoubleStream

        // If the maybeAverage optional doesn't have a value, default to 0
        return maybeAverage.orElse(0);
    }
    
    // Example 4: Same idea as during week 4, but implemented using a stream
    private static <T> Map<T, Long> countOccurences(List<T> list) {
        Map<T, Long> occurences = list.stream()
                .collect(groupingBy(s -> s, counting())); // Using groupingBy and counting collector

        return occurences;
    }
    
    // Example 5: Creating a HTML formatted version of the persons list.
    // This is typical in web programming while we are displaying data in HTML format
    public static String createHtmlList(List<Person> persons) {
        return persons.stream()
                .map(person -> "<li>Name: " + person.name() + ", Age: " + person.age() + "</li>")
                // Using Collectors.joining method to collect the result as a single string
                .collect(Collectors.joining("\n", "<ul>", "</ul>"));
    }

}

