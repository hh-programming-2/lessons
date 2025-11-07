package lesson4;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

/**
 * The purpose of this example is to illustrate the use of the Comparable
 * interface to be able to sort objects of our class.
 */
public class SortingStudents {
    public static void main(final String[] args) {
        List<Student> students = new LinkedList<>();
        Student kalle = new Student("123", "Kalle Ilves");
        Student john = new Student("456", "John Doe");
        Student otherKalle = new Student("123", "Kalle Ilves");
        Student mary = new Student("789", "Mary Poppins");

        // The compareteTo method compares studentNumber attributes
        System.out.println("Compare Kalle and John: " + kalle.compareTo(john));

        students.add(kalle);
        students.add(john);
        students.add(otherKalle);
        students.add(mary);

        // Sorting using the Comparable interface's compareTo method
        Collections.sort(students);
        System.out.println("Students sorted by student number:  " + students);
    }
}

/**
 * Let's add our own Student object to the example and see how we can sort a
 * list of Student objects based on the student number.
 * 
 * The class implements the Comparable interface, so Student can be
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
    public String toString() {
        return this.getStudentNumber();
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    /**
     * The compareTo method returns the following:
     * - 0 if this object matches the other object
     * - integer larger than 0 if the object is greater than the other object
     * - integer less than 0 if the object is less than the other object
     */
    @Override
    public int compareTo(Student other) {
        // We can simply use the compareTo implementation of Integer here
        return this.studentNumber.compareTo(other.studentNumber);
    }
}
