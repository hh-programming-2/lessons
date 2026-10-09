package lesson1;

public class Strings {
    public static void main(String[] args) {
         // Examples of string handling
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1 + ", " + str2;
        System.out.println(str3);

        // Checking string equality
        if (str1.equals("Hello")) {
            System.out.println("The string equals 'Hello'");
        }

        if (str1.equalsIgnoreCase("HELLO")) {
            System.out.println("The string equals 'Hello' while ignoring the case");
        }

        String text = "This is a sample text for demonstration.";
        String substring = "is";
        int index = text.indexOf(substring);

        System.out.println("Found in: " + index);

        if (index >= 0) {
            System.out.println("Found it!");
        }

        System.out.println("Index of '" + substring + "' in the text: " + index);

        String str = "Hello, World!";
        int length = str.length();
        System.out.println("Length of the string '" + str + "': " + length);
    }
}
