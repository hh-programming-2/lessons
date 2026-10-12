package lesson2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* This class should store student's grades from a course into a hash map in
* which the key is the student number and value the grade (between 0-5).
* For example: { "1234" -> 4, "5678" -> 3, "9876" -> 5 }
*/
public class CourseGrading {
    private final Map<String, Integer> studentGrades;

    public CourseGrading() {
        studentGrades = new HashMap<>();
    }

    /*
     * Adds the grade of the given student number.
     */
    public void addStudentGrade(String studentNumber, Integer grade) {
        studentGrades.put(studentNumber, grade);
    }

    /*
     * Returns the grade of the given student.
     */
    public Integer getStudentGrade(String studentNumber) {
        return studentGrades.get(studentNumber);
    }

    /*
     * Returns the average grade of the students.
     */
    public double getAverageGrade() {
        if (studentGrades.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (Integer grade : studentGrades.values()) {
            total += grade;
        }
        return total / studentGrades.size();
    }

    /*
     * Returns a list of students with a passimg grade.
     */
    public List<String> getPassingStudents() {
        List<String> passingStudents = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            if (entry.getValue() > 0) {
                passingStudents.add(entry.getKey());
            }
        }
        return passingStudents;
    }
}
