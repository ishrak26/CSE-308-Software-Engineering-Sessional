public class Student {
    private int id;
    private int marks;

    private Mediator mediator;

    public Student(int id, Mediator mediator) {
        setId(id);
        setMediator(mediator);
    }

    public void recheck() {
        System.out.println("Re-examine request sent to Exam Controller Office from student id " + getId());
        getMediator().recheck(this);
    }

    public void notifyMarks(int marks) {
        System.out.print("Results are out from the Exam Controller Office...");
        System.out.println("Student id " + getId() + " has obtained " + marks);
        setMarks(marks);
    }

    public void notifyRecheckMarks(int marks, boolean isChange) {
        System.out.print("Re-examine results are out from the Exam Controller Office...");
        if (isChange) {
            System.out.println("Student id " + getId() + " has now obtained " + marks + " marks instead of " +
                    getMarks());
            setMarks(marks);
        }
        else {
            System.out.println("There has been no change in marks after re-examine. Marks stays at " + getMarks());
        }
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
