import java.util.ArrayList;

public class ABCServer implements Subject {
    private ArrayList<Observer> observers;
    private int previousState;
    private int currentState;

    public ABCServer() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(previousState, currentState);
        }
    }

    public void stateChanged() {
        notifyObservers();
    }

    public void setCurrentState(int currentState) {
        this.previousState = this.currentState;
        this.currentState = currentState;
        stateChanged();
    }
}
