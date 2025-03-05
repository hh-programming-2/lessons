package lesson4;

import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * The purpose of this example is to illustrate the polymorphism of objects and
 * the use of interfaces.
 */
public class ListExamples {

    public static void main(final String[] args) {
        List<Integer> numberList = new LinkedList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(1);
        System.out.println(countOccurences(numberList));

        List<String> textList = new LinkedList<>();
        textList.add("Pekka");
        textList.add("Maija");
        textList.add("Elina");
        textList.add("Pekka");
        System.out.println(countOccurences(textList));

        List<MyObject> objectList = new LinkedList<>();
        objectList.add(new MyObject(1, "Volvo"));
        objectList.add(new MyObject(2, "Mersu"));
        objectList.add(new MyObject(3, "BMW"));
        objectList.add(new MyObject(4, "Volvo"));
        System.out.println(countOccurences(objectList));
        
        // Sorting using the Comparable interface
        Collections.sort(objectList);
        System.out.println("Aakkosjärjestetty autolista:  " + objectList);

    }

    /**
     * Counts the number of times each object is present in a list
     * 
     * @param list
     * @return The method returns a Map where the key is an object from the given List
     *         and the value is the count of how many times the same object appeared in the list.
     */
    private static <T> Map<T, Integer> countOccurences(List<T> list) {
        Map<T, Integer> result = new HashMap<>();
        for (T object : list) {
            if (result.containsKey(object)) {
                result.put(object, result.get(object) + 1);
            } else {
                result.put(object, 1);
            }
        }
        return result;
    }
}

/**
 * Let's add our own object to the example, which has an id and a text field, and
 * override the class's hashcode and equals methods so that only the similarity
 * of the text content means similarity. Then it can also be given for meaningful
 * comparison to the countOccurences method.
 * 
 * The class also implements the Comparable interface, so MyObjects can also be
 * sorted relative to each other. In this case, the sorting is done based on the
 * text using the String class's own compare implementation.
 * This practically causes MyObject to be sorted in alphabetical order.
 */
class MyObject implements Comparable<MyObject> {
    private int id;
    private String text;

    public MyObject(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MyObject)) {
            return false;
        }
        MyObject toinenObjekti = (MyObject) o;
        return this.text.equals(toinenObjekti.gettext());
    }

    @Override
    public int hashCode() {
        return this.text.hashCode();
    }

    @Override
    public String toString() {
        return this.gettext();
    }

    public String gettext() {
        return this.text;
    }

    @Override
    public int compareTo(MyObject other) {
        return this.text.compareTo(other.text);
    }
}
