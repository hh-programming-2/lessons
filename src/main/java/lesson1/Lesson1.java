package lesson1;

import java.util.ArrayList;
import java.util.List;

public class Lesson1 {

    public static void main(String[] args) {
        // Examples of variables
        int number = 42;
        double pi = 3.14;
        String message = "Hello, world!";
        boolean isJavaFun = true;

        // Examples of control structures
        if (isJavaFun) {
            System.out.println("Java is fun!");
        } else if (number == 43) {
            System.out.println("Java is also fun!");
        } else {
            System.out.println("Java is not fun?");
        }

        int dayOfWeek = 3;
            
        switch (dayOfWeek) {
            case 1:
                System.out.println("It's Monday");
                break;
            case 2:
                System.out.println("It's Tuesday");
                break;
            // ...

            default:
                System.out.println("It's some other day");
        }

        int x = 5;
        // Example of ternary operator
        int y = (x > 0) ? 1 : -1;


        // Examples of loops
        int[] numbersArray = { 1, 2, 3, 4, 5 };

        for (int i = 0; i < numbersArray.length; i++) {
            System.out.print(numbersArray[i] + " ");
        }
        
        for (int i = numbersArray.length - 1; i >= 0; i--) {
        	System.out.print(numbersArray[i] + " ");
        }

        for (int num : numbersArray) {
            System.out.print(num + " ");
        }

        int i = 0;
        while (i < 5) {
            System.out.print(i + " ");
            i++;
        }

        // Examples of methods
        int sum = add(3, 5);
        System.out.println("Sum: " + sum);

        // Examples of arrays and lists
        int[] array = { 1, 2, 3, 4, 5 };
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove(0);
        
        for (String n : list) {
        	System.out.println(n);
        }

        // Examples of object oriented programming
        Animal animal = new Animal("Elephant", 25);
        System.out.println("Name: " + animal.getName() + ", Age: " + animal.getWeight());

        // Example of exception handling
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Examples of string handling
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1 + ", " + str2;
        System.out.println(str3);
        
        String text = "This is a sample text for demonstration.";
        String substring = "is";
        int index = text.indexOf(substring);
        
        System.out.println("Found in: " + index);
        
        if (index >= 0) {
        	System.out.println("Found it!");
        }
        
        System.out.println("Index of \"" + substring + "\" in the text: " + index);

        String str = "Hello, World!";
        int length = str.length();
        System.out.println("Length of the string \"" + str + "\": " + length);

        // StringBuilder example
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Java ");
        stringBuilder.append("StringBuilder ");
        stringBuilder.append("example");
        System.out.println(stringBuilder.toString());
        
        // Same as this
        String withoutStringBuilder = "Java " + "StrinBuilder " + "example"; 
    }

    // Examples of methods
    public static int add(int a, int b) {
        return a + b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }

    // Example of a class
    static class Animal {
        private String name;
        private int weight;

        public Animal(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
