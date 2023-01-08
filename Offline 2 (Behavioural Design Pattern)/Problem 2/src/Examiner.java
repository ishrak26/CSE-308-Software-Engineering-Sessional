import java.util.HashMap;
import java.util.Random;

public class Examiner {
    private HashMap<Integer, Integer> marksheet;
    private Mediator mediator;
    private Random random;

    public Examiner(Mediator mediator) {
        setMediator(mediator);
        marksheet = new HashMap<>();
        random = new Random();
    }

    public void recheck(int studentID) {
        System.out.println("Re-examine request received to Examiner from Exam Controller Office for student id " + studentID);
        int previousMarks = getMarksheet().get(studentID);
        // add probability here
        int newMarks = previousMarks + random.nextInt() % 2;
        boolean isChange = (previousMarks != newMarks);
        if (isChange) {
            getMarksheet().put(studentID, newMarks);
            System.out.println("There was mistake in the previous marks...");
            System.out.println("Marks corrected from " + previousMarks + " to " + newMarks);
        }
        else {
            System.out.println("There is no change in marks after re-examine...");
        }
        System.out.println("Re-examine results sent to Exam Controller Office from Examiner for student id " + studentID);
        getMediator().receiveRecheckResult(this, isChange, studentID, newMarks);
    }

    public HashMap<Integer, Integer> getMarksheet() {
        return marksheet;
    }

    public void setMarksheet(HashMap<Integer, Integer> marksheet) {
        this.marksheet = marksheet;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void generateMarksheet(int studentCount) {
        for (int i = 1; i <= studentCount; i++) {
            getMarksheet().put(i, random.nextInt() % 100);
            if (getMarksheet().get(i) < 0) {
                getMarksheet().put(i, -getMarksheet().get(i));
            }
        }
    }

    public void sendMarksheet() {
        System.out.print("Scripts and marks of student id's ");
        int count = 0;
        for (Integer key : getMarksheet().keySet()) {
            System.out.print(key);
            count++;
            if (count < getMarksheet().size()) {
                System.out.print(", ");
            }
        }
        System.out.println(" sent to Exam Controller Office from Examiner");
        getMediator().receiveMarksheet(this, getMarksheet());
    }
}
