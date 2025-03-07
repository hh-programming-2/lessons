package lesson7.wordplay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        Set<String> words = new HashSet<>(finnishWords);
        Set<String> result = new HashSet<>();

        for (String name : finnishNames) {
            String lowerCaseName = name.toLowerCase();

            if (words.contains(lowerCaseName)) {
                result.add(name);
            }
        }

        System.out.println(result);
        System.out.println(result.size());
    }
}
