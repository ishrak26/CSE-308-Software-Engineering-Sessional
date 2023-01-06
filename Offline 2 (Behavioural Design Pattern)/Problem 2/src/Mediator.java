import java.util.HashMap;

public interface Mediator {
    public void receiveMarksheet(Examiner examiner, HashMap<Integer, Integer> marksheet);
    public void sendMark(Student student, int marks);
    public void recheck(Student student);
    public void receiveRecheckResult(Examiner examiner, boolean isChange, int studentID, int marks);
}
