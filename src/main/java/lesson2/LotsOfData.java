package lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * This example demonstrate the difference between using the HashMap and ArrayList data structures
 * with a large amount of data
 */
public class LotsOfData {

    public static void main(String[] args) {
        int dataSize = 10000000;
        Map<String, Integer> hashMap = createHashMap(dataSize);
        List<String> list = createArrayList(dataSize);

        // Calculates the time the containsKey (HashMap) search takes 
        long startTimeHashMap = System.currentTimeMillis();
        boolean containsKeyHashMap = hashMap.containsKey("non_existing_key");
        long endTimeHashMap = System.currentTimeMillis();
        System.out.println("HashMap containsKey: " + containsKeyHashMap);
        System.out.println("HashMap search time: " + (endTimeHashMap - startTimeHashMap) + " milliseconds");

        // Calculates the time the contains (ArrayList) search takes
        long startTimeList = System.currentTimeMillis();
        boolean containsList = list.contains("non_existing_key");
        long endTimeList = System.currentTimeMillis();
        System.out.println("ArrayList contains: " + containsList);
        System.out.println("ArrayList search time: " + (endTimeList - startTimeList) + " milliseconds");
        
        // In practice ArrayList's contains method goes through the whole list to find the answer
        for (String numero: list) {
            if (numero.equals("non_existing_key")) {
                break;
            }
        }
    }

    // Create a hash map containing random number values
    private static Map<String, Integer> createHashMap(int dataSize) {
        Map<String, Integer> hashMap = new HashMap<>(dataSize);
        Random random = new Random();
        for (int i = 0; i < dataSize; i++) {
            String key = String.valueOf(random.nextInt(dataSize));
            hashMap.put(key, i);
        }
        return hashMap;
    }

    // Create a list containing random number values
    private static List<String> createArrayList(int dataSize) {
        List<String> list = new ArrayList<>(dataSize);
        Random random = new Random();
        for (int i = 0; i < dataSize; i++) {
            String key = String.valueOf(random.nextInt(dataSize));
            list.add(key);
        }
        return list;
    }
}
