import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int STUDENT_COUNT = 5;

    public static void main(String[] args) {
        ExamController examController = new ExamController();
        // 5 students
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= Main.STUDENT_COUNT; i++) {
            students.add(new Student(i, examController));
            examController.registerStudent(students.get(i-1));
        }
        Examiner examiner = new Examiner(examController);
        examController.registerExaminer(examiner);
        examController.assginExaminerToStudent();
        examiner.generateMarksheet(Main.STUDENT_COUNT);

        examiner.sendMarksheet();

        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("Press 0 to exit");
            System.out.println("Otherwise, enter student id for re-examine application");

            int inp = scn.nextInt();
            if (inp == 0) {
                break;
            }
            else if (inp <= Main.STUDENT_COUNT) {
                students.get(inp-1).recheck();
            }
            else {
                System.out.println("Invalid input! Try again.");
            }
        }
    }
}