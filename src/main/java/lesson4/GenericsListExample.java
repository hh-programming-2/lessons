package lesson4;

import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * The purpose of this example is to illustrate the polymorphism of objects and
 * the use of interfaces.
 */
public class GenericsListExample {

    public static void main(final String[] args) {
        List<Integer> numberList = new LinkedList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(1);
        System.out.println(countOccurences(numberList));

        List<String> textList = new LinkedList<>();
        textList.add("Pekka");
        textList.add("Maija");
        textList.add("Elina");
        textList.add("Pekka");
        System.out.println(countOccurences(textList));

        List<Student> students = new LinkedList<>();
        Student kalle = new Student("123", "Kalle Ilves");
        Student john = new Student("456", "John Doe");
        Student otherKalle = new Student("123", "Kalle Ilves");
        Student mary = new Student("789", "Mary Poppins");

        // The equals method check equality based on the studentNumber attribute
        System.out.println("Are Kalle's the same?: " + kalle.equals(otherKalle));
        // The compareteTo method comparas studentNumber attributes
        System.out.println("Compare Kalle and John: " + kalle.compareTo(john));

        students.add(kalle);
        students.add(john);
        students.add(otherKalle);
        students.add(mary);

        System.out.println(countOccurences(students));

        // Sorting using the Comparable interface's compareTo method
        Collections.sort(students);
        System.out.println("Students sorted by student number:  " + students);
    }

    /**
     * Counts the number of times each object is present in a list
     * 
     * @param list
     * @return The method returns a Map where the key is an object from the given
     *         List
     *         and the value is the count of how many times the same object appeared
     *         in the list.
     */
    private static <T> Map<T, Integer> countOccurences(List<T> list) {
        // Now the method accepts any kind of list, so it is called a generic method.
        // This makes the method much more reusable
        Map<T, Integer> result = new HashMap<>();
        for (T object : list) {
            if (result.containsKey(object)) {
                result.put(object, result.get(object) + 1);
            } else {
                result.put(object, 1);
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
 * 
 * The class also implements the Comparable interface, so Student can also be
 * sorted relative to each other. In this case, the sorting is done based on the
 * studentNumber using the String class's own compare implementation.
 * This practically causes Student to be sorted in alphabetical order based on
 * the studentNumber.
 */
class Student implements Comparable<Student> {
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

    @Override
    public int compareTo(Student other) {
        return this.studentNumber.compareTo(other.studentNumber);
    }
}
