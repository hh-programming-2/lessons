package lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// This file contains examples of using the Map data structure
public class MapBasics {

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

        /*
         * HashMap: data structure for storing (key, value) pairs, e.g. country name
         * (key) mapping to the capital city (value):
         * { "Finland" -> "Helsinki", "Sweden" -> "Stockholm", "France" -> "Paris" }
         * Duplicate keys are not allowed!
         */

        // capitalCities is a map with country names (String) as keys and capital cities (String) as values
        Map<String, String> capitalCities = new HashMap<String, String>();
        // Note that key and value should be an object, not a primitive type (e.g.
        // Integer and not int)!
        // ❌ Map<int, String> badMap = new HashMap<int, String>();
        // ✔️ Map<Integer, String> goodMap = new HashMap<Integer, String>();

        capitalCities.put("Finland", "Helsinki");
        capitalCities.put("Sweden", "Stockholm");
        capitalCities.put("France", "Paris");
        capitalCities.put("Norway", "Oslo");

        System.out.println("1. capitalCities:" + capitalCities);
        System.out.println("1. Size of the capitalCities map: " + capitalCities.size());
        System.out.println("1. Capital city of Finland: " + capitalCities.get("Finland")); // "Helsinki"

        // Handling numbers in maps
        // credits is a map with course codes (String) as keys and credits (Integer) as values
        Map<String, Integer> credits = new HashMap<String, Integer>();

        // Adding values for keys
        credits.put("SOF001AS3AE", 5);
        credits.put("SOF012AS2AE", 2);
        credits.put("SOF007AS3AE", 10);
    
        // Getting a value
        Integer programming2Credits = credits.get("SOF001AS3AE");
        System.out.println("2. Credits of SOF001AS3AE: " + programming2Credits); // 5

        Integer missingCredits = credits.get("MISSING");
        System.out.println("2. Credits of MISSING: " + missingCredits); // null

        Integer defaultCredits = credits.getOrDefault("FAKE", 0);
        System.out.println("2. Credits of FAKE: " + defaultCredits); // 0

        // Setting a new value
        // productPrices is a map with product names (String) as keys and prices (Double) as values
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Coffee", 3.49);
        productPrices.put("Tea", 2.99);
        productPrices.put("Chips", 1.5);
        productPrices.put("Milk", 0.99);

        productPrices.put("Coffee", 3.79); // replaces the previous value!
        productPrices.putIfAbsent("Tea", 3.25); // doesn't replace anything
        productPrices.replace("Juice", 4.50); // does not add anything

        System.out.println("3. Product prices: " + productPrices);

        // Removing values (remove) and checking existence (containsKey)
        if (productPrices.containsKey("Tea")) {
            System.out.println("4. We have tea priced at " + productPrices.get("Tea"));
        }

        productPrices.remove("Tea");
        productPrices.containsKey("Tea"); // false

        System.out.println("4. Product prices after remove: " + productPrices);

        // Setting multiple values for the same key
        // contryCities is a map with country names (String) as keys and list of cities (List<String>) as values
        Map<String, List<String>> countryCities = new HashMap<>();

        List<String> citiesOfFinland = new ArrayList<String>();
        citiesOfFinland.add("Helsinki");
        citiesOfFinland.add("Espoo");
        citiesOfFinland.add("Vantaa");

        List<String> cititesOfSweden = new ArrayList<String>();
        cititesOfSweden.add("Stockholm");
        cititesOfSweden.add("Visby");

        countryCities.put("Finland", citiesOfFinland);
        countryCities.put("Sweden", cititesOfSweden);

        System.out.println("5. Cities of countries:" + countryCities);
        System.out.println("5. Cities of Sweden: " + countryCities.get("Sweden"));

        citiesOfFinland.add("Tampere");
        System.out.println("5. Cities of Finland:" + countryCities.get("Finland"));

        // Going through the keys of a map
        for (String key : productPrices.keySet()) {
            System.out.println("6. key: " + key);
        }

        // Go through the values of a map
        for (Double value : productPrices.values()) {
            System.out.println("7. value: " + value);
        }

        // Go through the key-value pairs of a map
        System.out.println("8. Iterating key-value pairs with for loop:");

        for (Entry<String, Double> keyValuePair : productPrices.entrySet()) {
            System.out.println("Key: " + keyValuePair.getKey());
            System.out.println("Value: " + keyValuePair.getValue());
        }

        // Other way of going through all key-value pairs using forEach method and an
        // lamda function
        System.out.println("9. Iterating key-value pairs with forEach method:");

        productPrices.forEach((key, value) -> {
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        });
    }
}
