public class Student {
    private int id;
    private int marks;

    private Mediator mediator;

    public Student(int id, Mediator mediator) {
        setId(id);
        setMediator(mediator);
    }

    public void recheck() {
        mediator.recheck(this);
    }

    public void notifyMarks(int marks) {
        System.out.print("Results are out from the Exam Controller Office...");
        System.out.println("Student with id = " + getId() + " has obtained " + marks);
        setMarks(marks);
    }

    public void notifyRecheckMarks(int marks) {
        System.out.print("Recheck results are out from the Exam Controller Office...");
        System.out.println("Student with id = " + getId() + " has obtained " + marks);
        setMarks(marks);
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
