import java.util.HashMap;

public class Examiner {
    private HashMap<Integer, Integer> marksheet;
    private Mediator mediator;

    public Examiner(Mediator mediator) {
        setMediator(mediator);
        marksheet = new HashMap<>();
    }

    public void recheck(int studentID) {
        int previousMarks = marksheet.get(studentID);
        // add probability here
        int newMarks = previousMarks;
        boolean isChange = (previousMarks != newMarks);
        if (isChange) {
            marksheet.put(studentID, newMarks);
        }
        mediator.receiveRecheckResult(this, isChange, studentID, newMarks);
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
}
