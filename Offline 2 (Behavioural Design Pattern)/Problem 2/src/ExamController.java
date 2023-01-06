import java.util.*;

import static java.lang.Math.max;

public class ExamController implements Mediator {
    private HashMap<Integer, Student> students;
    private List<Examiner> examiners;
    private HashMap<Student, Examiner> studentToExaminer;

    private Random random;

    public ExamController() {
        students = new HashMap<>();
        examiners = new ArrayList<>();
        studentToExaminer = new HashMap<>();
        random = new Random();
    }

    public void registerStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void registerExaminer(Examiner examiner) {
        examiners.add(examiner);
    }

    // for this particular offline only
    // assign the same examiner to all students
    public void assginExaminerToStudent() {
        for (Student student : students.values()) {
            studentToExaminer.put(student, examiners.get(0));
        }
    }

    public int scrutinize(int id, int previousMarks) {
        // add probability later
        if (random.nextInt() % 2 == 0) {
            int change = random.nextInt() % 3;
            if (change == 0) {
                change++;
            }
            int newMarks = max(0, previousMarks + change);
            System.out.println("Marks of student id " + id + " has been corrected to " +
                    newMarks + " from " + previousMarks + " during scrutinization");
            return newMarks;
        }
        return previousMarks;
    }

    @Override
    public void receiveMarksheet(Examiner examiner, HashMap<Integer, Integer> marksheet) {
        System.out.println("Marksheet received from examiner.");
        for (Map.Entry<Integer, Integer> e : marksheet.entrySet()) {
            System.out.println("Student id " + e.getKey() + " has obtained " + e.getValue() + " marks.");
        }
        for (Map.Entry<Integer, Integer> e : marksheet.entrySet()) {
            marksheet.put(e.getKey(), scrutinize(e.getKey(), e.getValue()));
//            students.get(e.getKey()).notifyMarks(e.getValue());
            sendMark(students.get(e.getKey()), e.getValue());
        }
    }

    @Override
    public void sendMark(Student student, int marks) {
        student.notifyMarks(marks);
    }

    @Override
    public void recheck(Student student) {
        System.out.println("Re-examine request got from student id " + student.getId());
        // find corresponding examiner
        studentToExaminer.get(student).recheck(student.getId());
    }

    @Override
    public void receiveRecheckResult(Examiner examiner, boolean isChange, int studentID, int marks) {
        if (isChange) {
            System.out.println("There has been a correction for student id " + studentID);
        }
        System.out.println("Re-examine results sent from Exam Controller Office to student id " + studentID);
        students.get(studentID).notifyRecheckMarks(marks, isChange);
    }
}
