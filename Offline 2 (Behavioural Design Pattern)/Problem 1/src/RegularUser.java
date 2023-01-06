import java.util.Scanner;

public class RegularUser implements Observer {
    private int previousState;
    private int currentState;
    private Subject server;

    private Scanner scn;
    private boolean fullFunction = false;

    public RegularUser(Subject server) {
        this.server = server;
        server.registerObserver(this);
        scn = new Scanner(System.in);
    }

    @Override
    public void update(int previousState, int currentState) {
        setPreviousState(previousState);
        setCurrentState(currentState);
        printMessage();
    }

    public void printMessage() {
        System.out.println("Regular User:");
        if (getPreviousState() == States.OPERATIONAL) {
            if (getCurrentState() == States.PARTIALLY_DOWN) {
                System.out.println("Please choose one of the following options:");
                System.out.println("1. Continue using the limited functionality");
                System.out.println("2. Pay $20 per hour to enjoy the full functionality taking service " +
                        "from server of DEF (we will copy all your data to the server of DEF, so none of your data will " +
                        "be lost)");
                int inp = scn.nextInt();
                if (inp == 1) {
                    setFullFunction(false);
                    System.out.println("You have chosen to continue using the limited functionality");
                }
                else if (inp == 2) {
                    setFullFunction(true);
                    System.out.println("Congratulations on upgrading to full functionality! You will now be " +
                            "charged $20 per hour");
                }
                else {
                    System.out.println("Invalid input. Please try again.");
                    printMessage();
                }
            }
            else {
                System.out.println("Our server is fully down now. But you can still have uninterrupted services, thanks " +
                        "to the server of DEF company. We will copy all your data to the server of DEF company. " +
                        "So none of your data will be lost. You will be charged $20 per hour for this. " +
                        "Do you wish to continue?");
                System.out.println("1. Yes, continue");
                System.out.println("2. No, don't continue");
                int inp = scn.nextInt();
                if (inp == 1) {
                    setFullFunction(true);
                    System.out.println("Congratulations on upgrading to full functionality! You will now be " +
                            "charged $20 per hour");
                }
                else if (inp == 2) {
                    setFullFunction(false);
                    System.out.println("Since our server is down, we can no longer provide service to you. " +
                            "Please wait until we can get our server running again...");
                }
                else {
                    System.out.println("Invalid input. Please try again.");
                    printMessage();
                }
            }
        }
        else if (getPreviousState() == States.PARTIALLY_DOWN) {
            if (getCurrentState() == States.OPERATIONAL) {
                System.out.println("Our server is fully operational now");
                if (isFullFunction()) {
                    System.out.println("Your bill for using the fully functional service is x");
                }
            }
            else {
                System.out.println("Our server is fully down now");
            }
        }
        else {
            if (getCurrentState() == States.OPERATIONAL) {
                System.out.println("Our server is fully operational now");
                if (isFullFunction()) {
                    System.out.println("Your bill for using the fully functional service is x");
                }
            }
            else {
                System.out.println("Our server is partially down now");
            }
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

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public boolean isFullFunction() {
        return fullFunction;
    }

    public void setFullFunction(boolean fullFunction) {
        this.fullFunction = fullFunction;
    }
}
