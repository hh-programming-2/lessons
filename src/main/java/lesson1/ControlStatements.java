package lesson1;

public class ControlStatements {

    public static void main(String[] args) {
        // Examples of variables
        int grade = 5;
        double price = 2.5;
        String message = "Hello world!";
        boolean isJavaFun = true;
        boolean isBestGrade = grade == 5;

        // Examples of conditional statements
        if (isJavaFun) {
            System.out.println("Java is fun!");
        } else if (grade == 0) {
            System.out.println("That is a failing grade");
        } else {
            System.out.println("Java is not fun?");
        }

        int dayOfWeek = 3;

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Some other day");
        }

        int age = 19;
        // Example of ? ternary operator
        String ageDescription = age < 18 ? "Minor" : "Adult";
        System.out.println("Age description: " + ageDescription);

        // Examples of methods
        int sum = add(3, 5);
        System.out.println("Sum: " + sum);

        int division = divide(4, 2);
        System.out.println("Division: " + division);

        // Example of exception handling
        // divide(10, 0);
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Examples of methods
    public static int add(int a, int b) {
        return a + b;
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
