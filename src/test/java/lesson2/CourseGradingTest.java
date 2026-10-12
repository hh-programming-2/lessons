package lesson2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

class CourseGradingTest {
    @Test
    void storesGradesAndReturnsAverageAndPassingStudents() {
        CourseGrading courseGrading = new CourseGrading();
        courseGrading.addStudentGrade("1234", 4);
        courseGrading.addStudentGrade("5678", 0);
        courseGrading.addStudentGrade("9876", 2);

        assertEquals(4, courseGrading.getStudentGrade("1234"));
        assertEquals(2.0, courseGrading.getAverageGrade());
        assertEquals(Set.of("1234", "9876"), Set.copyOf(courseGrading.getPassingStudents()));
    }

    @Test
    void returnsNullForUnknownStudentAndZeroAverageWhenEmpty() {
        CourseGrading courseGrading = new CourseGrading();

        assertNull(courseGrading.getStudentGrade("missing"));
        assertEquals(0.0, courseGrading.getAverageGrade());
        assertEquals(Set.of(), Set.copyOf(courseGrading.getPassingStudents()));
    }
}
