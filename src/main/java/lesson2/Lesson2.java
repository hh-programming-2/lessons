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

        // 1. Hash map
        Map<String, String> postalCodes = new HashMap<String, String>();

        postalCodes.put("00710", "Helsinki");
        postalCodes.put("90014", "Oulu");
        postalCodes.put("33720", "Tampere");
        postalCodes.put("33014", "Tampere");
        
        System.out.println("1. Postal code 00710: " + postalCodes.get("00710")); // prints "Helsinki"

        // 2. Handling numbers in maps
        Map<String, Integer> credits = new HashMap<String, Integer>();

        // Adding values for keys
        credits.put("swd1tn001", 5);
        credits.put("swd1tn002", 5);

        // Getting a value
        int courseCredits = credits.get("swd1tn002");
        System.out.println("2. Credits swd1tn002: " + courseCredits); // 5
        
        Integer fakeCredits = credits.getOrDefault("fakecourse", 0);
        System.out.println("2.1. Credits fakecourse: " + fakeCredits); // 0

        // 3. Setting a new value
        Map<String, String> numbers = new HashMap<>();
        numbers.put("Uno", "Yksi");
        numbers.put("Dos", "Zwei");
        numbers.put("Uno", "Ein"); // replaces the previous value!
        numbers.putIfAbsent("Dos", "Kaksi"); // doesn't replace anything
        numbers.replace("Tres", "Drei"); // does not add anything

        System.out.println("3. Numerot: " + numbers);

        // 4. Removing values (remove) and checking existence (containsKey)
        Map<String, String> countries = new HashMap<>();
        countries.put("Suomi", "Finland");
        countries.put("Ruotsi", "Sweden");
        countries.put("Norja", "Norway");
        countries.containsKey("Ruotsi"); // true
        countries.remove("Ruotsi");
        countries.containsKey("Ruotsi"); // false

        System.out.println("4. Countries:" + countries);

        // 5. Setting multiple values for the same key
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

        // 6. Going through the map values
        Set<String> keys = numbers.keySet();
        
        // Go through all the keys
        for (String key : keys) {
            System.out.println("6.1 key: " + key);
        }

        Collection<String> values = numbers.values();
        
        // Go through all the values
        for (String value : values) {
            System.out.println("6.3 value: " + value);
        }
        
        // Go through all key-value pairs
        // Set<Entry<String, String>> entrySet = numbers.entrySet();
        for (Entry<String, String> keyValuePair : numbers.entrySet()) {
	        System.out.println("Key: " + keyValuePair.getKey());
	        System.out.println("Value: " + keyValuePair.getValue());
        }

    }
}
