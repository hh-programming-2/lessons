package lesson4;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The purpose of this example is to illustrate the polymorphism of objects and
 * generic methods.
 */
public class GenericsExample {

    public static void main(final String[] args) {
        List<String> textList = new ArrayList<>();
        textList.add("Pekka");
        textList.add("Maija");
        textList.add("Elina");
        textList.add("Pekka");
        System.out.println("Occurences in String list: " + countOccurencesOfStrings(textList));

        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(1);
        System.out.println("Occurences in Integer list: " + countOccurences(numberList));

        List<Student> students = new ArrayList<>();
        Student kalle = new Student("123", "Kalle Ilves");
        Student john = new Student("456", "John Doe");
        Student otherKalle = new Student("123", "Kalle Ilves");
        Student mary = new Student("789", "Mary Poppins");

        // The equals method check equality based on the studentNumber attribute
        System.out.println("Are Kalle's the same?: " + kalle.equals(otherKalle));

        students.add(kalle);
        students.add(john);
        students.add(otherKalle);
        students.add(mary);

        System.out.println("Occurences in Student list: " + countOccurences(students));
    }

    /**
     * Counts the number of times each string is present in a list
     */
    private static Map<String, Integer> countOccurencesOfStrings(List<String> list) {
        // The parameter type is List<String>, but we don't actually need to know the
        // type of the list item to perform these hash map operations
        Map<String, Integer> result = new HashMap<>();
        for (String item : list) {
            if (result.containsKey(item)) {
                result.put(item, result.get(item) + 1);
            } else {
                result.put(item, 1);
            }
        }
        return result;
    }

    /**
     * Counts the number of times each object is present in a list
     */
    private static <T> Map<T, Integer> countOccurences(List<T> list) {
        // Now the method accepts any kind of list, so it is called a generic method.
        // This makes the method much more reusable
        Map<T, Integer> result = new HashMap<>();
        for (T item : list) {
            if (result.containsKey(item)) {
                result.put(item, result.get(item) + 1);
            } else {
                result.put(item, 1);
            }
        }
        return result;
    }  
}

/**
 * Let's add our own Student object to the example, which has an student number
 * and a name field, and override the class's hashCode and equals methods so
 * that only the similarity of the studentNumber attribute means similarity.
 * Then it can also be given for meaningful comparison to the countOccurences
 * method.
 */
class Student {
    private String studentNumber;
    private String name;

    public Student(String studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }
        Student otherStudent = (Student) o;
        return this.studentNumber.equals(otherStudent.studentNumber);
    }

    @Override
    public int hashCode() {
        return this.studentNumber.hashCode();
    }

    @Override
    public String toString() {
        return this.getStudentNumber();
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }
}
