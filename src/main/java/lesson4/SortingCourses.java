package lesson4;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

/**
 * The purpose of this example is to illustrate the use of the Comparable
 * interface to be able to sort objects of our own class.
 */
public class SortingCourses {
    public static void main(final String[] args) {
        List<Course> courses = new LinkedList<>();
        Course sql = new Course("SQL Databases", 10);
        Course python = new Course("Python Programming", 5);
        Course noSql = new Course("NoSQL Databases", 2);

        // The compareteTo method compares credits attributes
        System.out.println("Compare SQL Databases and Python Programming: " + sql.compareTo(python));

        courses.add(sql);
        courses.add(python);
        courses.add(noSql);

        // Sorting using the Comparable interface's compareTo method
        Collections.sort(courses);
        System.out.println("Courses sorted by credits:  " + courses);
    }
}

/**
 * Let's add our own Course class to the example and see how we can sort a
 * list of Course objects based on the number of credits.
 * 
 * The class implements the Comparable interface, so Course can be
 * sorted relative to each other. In this case, the sorting is done based on the
 * credits using the Integer class's own compare implementation.
 * This practically causes Course to be sorted in ascending order based on
 * the credits attribute.
 */
class Course implements Comparable<Course> {
    private String name;
    private Integer credits;

    public Course(String name, Integer credits) {
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.credits + " credits)";
    }

    public Integer getCredits() {
        return this.credits;
    }

    public String getName() {
        return this.name;
    }

    /**
     * The compareTo method returns the following:
     * - 0 if this object matches the other object
     * - integer larger than 0 if this object is greater than the other object
     * - integer less than 0 if this object is less than the other object
     */
    @Override
    public int compareTo(Course other) {
        // We can simply use the compareTo implementation of Integer class here
        return this.credits.compareTo(other.credits);
    }
}
