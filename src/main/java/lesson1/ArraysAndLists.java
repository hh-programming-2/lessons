package lesson1;

import java.util.ArrayList;
import java.util.List;

public class ArraysAndLists {
    public static void main(String[] args) {
        // Examples of an array
        int[] numbersArray = { 1, 9, 4, 12, 5, 8 };

        // Examples of loops
        System.out.println("Numbers from 0 to 4:");
        int number = 0;
        while (number < 5) {
            System.out.println(number);
            number++;
        }

        System.out.println("All numbers:");
        
        for (int i = 0; i < numbersArray.length; i++) {
            System.out.println(numbersArray[i]);
        }

        System.out.println("Numbers backwards:");
        
        for (int i = numbersArray.length - 1; i >= 0; i--) {
            System.out.println(numbersArray[i]);
        }
        
        // Example of for each loop
        System.out.println("All numbers with for each loop:");
        
        for (int num : numbersArray) {
            System.out.println(num);
        }

        // Example of a list
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("hej");
        words.add("moi");
        words.add("salut");
        words.remove(0);

        System.out.println("All words:");

        for (String word : words) {
            System.out.println(word);
        }
    }
}
