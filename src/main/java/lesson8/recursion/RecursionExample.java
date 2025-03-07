package lesson8.recursion;


// The purpose of this example is to demonstrate recursive functions, which perform operations by calling themselves
public class RecursionExample {
    public static void main(String[] args) {
        int number = 5;

        System.out.println("Recursive calculateFactorial result: " + calculateFactorial(number));
        
        printBackwards("Hello world!");
    }

    // A recursive function for calculating the factorial of the provided number by calling itself
    // calculateFactorial(5) = 1 * 2 * 3 * 4 * 5 = 120
    private static int calculateFactorial(int n) {
        // The base case: factorial of 0 is 1
        if (n == 0) {
            // It is important to each recursive function to have a base case, otherwise the recursin will never end
            return 1;
        } else {
            // Recursive case: factorial(n) = n * factorial(n - 1)
            return n * calculateFactorial(n - 1);
        }
    }
    
    // A recursive function for printing a string backwards
    private static void printBackwards(String text) {
        // Base case: empty or string with a single character
        if (text.length() <= 1) {
            System.out.print(text);
        } else {
            // Recursive case: print the last character and call the function without it
            System.out.print(text.charAt(text.length() - 1));
            printBackwards(text.substring(0, text.length() - 1));
        }
    }
}
