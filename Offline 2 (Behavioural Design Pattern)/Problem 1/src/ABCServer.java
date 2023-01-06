import java.util.ArrayList;

public class ABCServer implements Subject {
    private ArrayList<Observer> observers;
    private int previousState;
    private int currentState;

    public ABCServer() {
        observers = new ArrayList<>();
        currentState = States.OPERATIONAL;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
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

    public void changeState(String newState) {
        if (newState.equalsIgnoreCase("Operational")) {
            setCurrentState(States.OPERATIONAL);
        }
        else if (newState.equalsIgnoreCase("Partially Down")) {
            setCurrentState(States.PARTIALLY_DOWN);
        }
        else if (newState.equalsIgnoreCase("Fully Down")) {
            setCurrentState(States.FULLY_DOWN);
        }
        else {
            System.out.println("Invalid state!");
        }
    }

    public String getServerState() {
        if (getCurrentState() == States.OPERATIONAL) {
            return "Operational";
        }
        else if (getCurrentState() == States.PARTIALLY_DOWN) {
            return "Partially Down";
        }
        else {
            return "Fully Down";
        }
    }

    public void setCurrentState(int currentState) {
        setPreviousState(getCurrentState());
        this.currentState = currentState;
        if (getPreviousState() != getCurrentState()) {
            stateChanged();
        }
    }

    public int getPreviousState() {
        return previousState;
    }

    public void setPreviousState(int previousState) {
        this.previousState = previousState;
    }

    public int getCurrentState() {
        return currentState;
    }
}
