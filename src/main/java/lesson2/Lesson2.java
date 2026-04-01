package lesson2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// This file contains examples of using the Map data structure
public class Lesson2 {

    public static void main(String[] args) {
        /*
         * "A data structure is a collection of data values, the relationships among
         * them, and the functions or operations that can be applied to the data."
         */

        // Array: primitive data structure of fixed size for storing items in order
        String[] namesArray = new String[2];
        namesArray[0] = "Kalle";
        namesArray[1] = "Elina";

        // ArrayList: data structure of dynamic size for storing items in order
        List<String> namesList = new ArrayList<>();
        namesList.add("Kalle");
        namesList.add("Elina");
        namesList.add("Pekka");
        // ArrayList provides many operations, such as containment check
        namesList.contains("Kalle");

        // HashMap: data structure for storing (key, value) pairs
        Map<String, String> postalCodes = new HashMap<String, String>();
        // Note that key and value should be an object, not a primitive type (e.g.
        // Integer and not int)!
        // ❌ Map<int, String> badMap = new HashMap<int, String>();
        // ✔️ Map<Integer, String> goodMap = new HashMap<Integer, String>();

        postalCodes.put("00720", "Helsinki");
        postalCodes.put("90014", "Oulu");
        postalCodes.put("33720", "Tampere");
        postalCodes.put("33014", "Tampere");

        System.out.println("1. postalCodes:" + postalCodes);
        System.out.println("1.1. Postal code 00710: " + postalCodes.get("00710")); // prints "Helsinki"

        // Handling numbers in maps
        Map<String, Integer> credits = new HashMap<String, Integer>();

        // Adding values for keys
        credits.put("swd1tn001", 5);
        credits.put("swd1tn002", 5);

        // Getting a value
        int courseCredits = credits.get("swd1tn001");
        System.out.println("2. Credits swd1tn002: " + courseCredits); // 5

        Integer fakeCredits = credits.getOrDefault("fakecourse", 0);
        System.out.println("2.1. Credits fakecourse: " + fakeCredits); // 0

        // Setting a new value
        Map<String, String> numbers = new HashMap<>();
        numbers.put("Uno", "Yksi");
        numbers.put("Dos", "Zwei");
        numbers.put("Uno", "Ein"); // replaces the previous value!
        numbers.putIfAbsent("Dos", "Kaksi"); // doesn't replace anything
        numbers.replace("Tres", "Drei"); // does not add anything

        System.out.println("3. Numbers: " + numbers);

        // Removing values (remove) and checking existence (containsKey)
        Map<String, String> countries = new HashMap<>();
        countries.put("Suomi", "Finland");
        countries.put("Ruotsi", "Sweden");
        countries.put("Norja", "Norway");
        countries.containsKey("Ruotsi"); // true
        countries.remove("Ruotsi");
        countries.containsKey("Ruotsi"); // false

        System.out.println("4. Countries:" + countries);

        // Setting multiple values for the same key
        Map<String, List<String>> countryCities = new HashMap<>();

        List<String> fi = new ArrayList<String>();
        fi.add("Helsinki");
        fi.add("Espoo");
        fi.add("Vantaa");

        List<String> sv = new ArrayList<String>();
        sv.add("Stockholm");
        sv.add("Visby");

        countryCities.put("Finland", fi);
        countryCities.put("Sweden", sv);

        System.out.println("5. Citites:" + countryCities);

        fi.add("Tampere");
        System.out.println("5.1. Citities including Tampere:" + countryCities);

        // Going through the keys of a map
        Set<String> keys = numbers.keySet();

        for (String key : keys) {
            System.out.println("6.1. key: " + key);
        }

        // Go through the values of a map
        Collection<String> values = numbers.values();

        for (String value : values) {
            System.out.println("6.2. value: " + value);
        }

        // Go through the key-value pairs of a map
        Set<Entry<String, String>> entrySet = numbers.entrySet();
        System.out.println("7. Iterating key-value pairs with for loop:");

        for (Entry<String, String> keyValuePair : entrySet) {
            System.out.println("Key: " + keyValuePair.getKey());
            System.out.println("Value: " + keyValuePair.getValue());
        }

        // Other way of going through all key-value pairs using forEach method and an
        // lamda function
        System.out.println("8. Iterating key-value pairs with forEach method:");

        numbers.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });
    }
}
