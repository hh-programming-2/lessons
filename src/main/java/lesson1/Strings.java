package lesson1;

public class Strings {
    public static void main(String[] args) {
         // Examples of string handling
        String str1 = "Hello";
        String str2 = "world";
        String str3 = str1 + " " + str2;
        System.out.println(str3);

        // Checking if string's text matches another string's text
        if (str1.equals("Hello")) {
            System.out.println("The string equals 'Hello'");
        }

        if (str1.equalsIgnoreCase("HELLO")) {
            System.out.println("The string equals 'HELLO' while ignoring the case");
        }

        String text = "This is a sample text for demonstration.";
        String substring = "is";
        int index = text.indexOf(substring);

        System.out.println("Index of '" + substring + "' in the text: " + index);

        if (index >= 0) {
            System.out.println("Found it!");
        }

        String str = "Hello world!";
        int length = str.length();
        System.out.println("Length of the string '" + str + "': " + length);
    }
}
