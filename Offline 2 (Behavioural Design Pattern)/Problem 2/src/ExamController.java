import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamController implements Mediator {
    private HashMap<Integer, Student> students;
    private List<Examiner> examiners;
    private HashMap<Student, Examiner> studentToExaminer;

    public ExamController() {
        students = new HashMap<>();
        examiners = new ArrayList<>();
        studentToExaminer = new HashMap<>();
    }

    public void registerStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void registerExaminer(Examiner examiner) {
        examiners.add(examiner);
    }

    public int scrutinize(int id, int previousMarks) {
        // add probability later
        return previousMarks;
    }

    @Override
    public void receiveMarksheet(Examiner examiner, HashMap<Integer, Integer> marksheet) {
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
        // find corresponding examiner
        studentToExaminer.get(student).recheck(student.getId());
    }

    @Override
    public void receiveRecheckResult(Examiner examiner, boolean isChange, int studentID, int marks) {
        if (isChange) {
            students.get(studentID).notifyRecheckMarks(marks);
        }
    }
}
