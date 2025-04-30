package lesson7.wordplay;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lesson7.wordplay.io.DictionaryReader;
import lesson7.wordplay.io.NamesReader;

public class NamesInDictionary {

    private static List<String> finnishNames = NamesReader.readFirstNames();
    private static List<String> finnishWords = DictionaryReader.readFinnishWords();

    public static void main(String[] args) {
        /*
         * Implement a program that prints all Finnish names that are also
         * found in the Finnish dictionary.
         *
         * You can use the finnishNames and finnishWords variables defined above
         * as the data set you need to process. Notice that the words are in lower case
         * but the names are not. The names can contain duplicates, as there are several
         * unisex names in the data set.
         *
         * Try to make your program as efficient as possible. A good goal is to have
         * the program run in tenths of a second.
         *
         * Good luck!
         */

        
        // Slow solution
    
        Instant startTime = Instant.now();

        for (String name : finnishNames) {
            if (finnishWords.contains(name.toLowerCase())) {
                // System.out.println(name);
            }
        }

        Instant endTime = Instant.now();

        System.out.println("Slow solution: " + Duration.between(startTime, endTime));

        // Fast solution

        startTime = Instant.now();

        // Convert all names to lowercase and make a set. The set will not contain
        // any duplicates nor blank strings, and is very fast to access.
        // Creating the set will take linear time relative to the amount of names
        // (O(n)).
        Set<String> nameSet = finnishNames
                .stream()
                .filter(name -> !name.isBlank())
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        // Make a similar set of the words removing duplicates and blanks,
        // and converting each word to lowercase.
        // Creating the set will take linear time relative to the amount of words
        // (O(n)).
        Set<String> wordSet = finnishWords
                .stream()
                .filter(word -> !word.isBlank())
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        // Finally, filter a new list of words, that are in both sets.
        // Filtering the set will take linear time relative to the amount of words
        // (O(n)), as
        // each lookup to the nameSet will take the same time regardless of the set
        // size.
        List<String> result = wordSet
                .stream()
                .filter(w -> nameSet.contains(w))
                .toList();

        /*
         * NOTE: list.contains(w) has time complexity of O(n), so using a list would
         * have caused the previous stream's time complexity to be: n times O(n)
         * operation = O(n²)
         */

        System.out.println("There were " + result.size() + " names that are in dictionary:");

        endTime = Instant.now();

        System.out.println("Fast solution: " + Duration.between(startTime, endTime));
        /*
         * To sum up, all previous steps took a linear time relative to the size of the
         * program's input:
         * O(n) + O(n) + O(n) => O(3n)
         * 
         * In Big-O notation we are estimating how the function grows relative to the
         * input size.
         * Therefore O(3n) can be expressed as O(n), as both grow linearly relative to
         * the input,
         * regardless of the constant factor.
         */
        
        // System.out.println(String.join("\n", result));
    }
}
