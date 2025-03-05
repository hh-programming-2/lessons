package lesson4;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * The purpose of this example is to illustrate the polymorphism of objects and
 * the use of interfaces.
 */
public class ListExampleWithoutCustomObject {

    public static void main(final String[] args) {
        List<Integer> numberList = new LinkedList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(1);
        System.out.println(countOccurences(numberList));
    }

    /**
     * Counts the number of times each object is present in a list
     * 
     * @param list
     * @return The method returns a Map where the key is an object from the given List
     *         and the value is the count of how many times the same object appeared in the list.
     */
    private static Map<Integer, Integer> countOccurences(List<Integer> list) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Integer numero : list) {
            if (result.containsKey(numero)) {
                result.put(numero, result.get(numero) + 1);
            } else {
                result.put(numero, 1);
            }
        }
        return result;
    }
}
