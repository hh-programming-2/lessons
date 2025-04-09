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
public class ListExample {

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
        students.add(new Student("123", "Kalle Ilves"));
        students.add(new Student("456", "John Doe"));
        students.add(new Student("123", "Kalle Ilves"));
        students.add(new Student("789", "Mary Poppins"));
        System.out.println(countOccurences(students));

        // Sorting using the Comparable interface
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
 * and a name field, and override the class's hashcode and equals methods so
 * that only the similarity of the text content means similarity. Then it can
 * also be given for meaningful comparison to the countOccurences method.
 * 
 * The class also implements the Comparable interface, so Student can also be
 * sorted relative to each other. In this case, the sorting is done based on the
 * text using the String class's own compare implementation.
 * This practically causes Student to be sorted in alphabetical order.
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
