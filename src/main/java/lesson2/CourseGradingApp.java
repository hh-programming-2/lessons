package lesson2;

public class CourseGradingApp {
    public static void main(String[] args) {
        CourseGrading programming2 = new CourseGrading();

        programming2.addStudentGrade("1234", 4);
        programming2.addStudentGrade("5678", 3);
        programming2.addStudentGrade("9876", 5);
        programming2.addStudentGrade("1111", 1);

        System.out.println("Printing the grades:");
        System.out.println(programming2.getStudentGrade("111")); // should be 1
        System.out.println(programming2.getStudentGrade("9876")); // should be 5
        System.out.println(programming2.getStudentGrade("9999")); // should be null

        System.out.println("Printing the average:");
        System.out.println(programming2.getAverageGrade()); // should be (4+3+5+1)/4 = 3.25
    }
}
