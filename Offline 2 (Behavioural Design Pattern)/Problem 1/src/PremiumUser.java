import java.util.Scanner;

public class PremiumUser implements Observer {
    private int previousState;
    private int currentState;
    private Subject server;

    private Scanner scn;
    private boolean twoServer = false;

    public PremiumUser(Subject server) {
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
        System.out.println("Premium User:");
        if (getPreviousState() == States.OPERATIONAL) {
            if (getCurrentState() == States.PARTIALLY_DOWN) {
                System.out.println("Our server is now partially down...");
                System.out.println("Please choose one of the following options:");
                System.out.println("1. Use service from two servers (partially from ABC and partially from DEF");
                System.out.println("2. Use service only from DEF");
                int inp = scn.nextInt();
                if (inp == 1) {
                    setTwoServer(true);
                    System.out.println("You will now use service from two servers- partially from ABC and partially " +
                            "from DEF");
                }
                else if (inp == 2) {
                    setTwoServer(false);
                    System.out.println("You will now use service only from DEF");
                }
                else {
                    System.out.println("Invalid input. Please try again.");
                    printMessage();
                }
            }
            else {
                System.out.println("Our server is now fully down");
                System.out.println("Our service is now provided by our partner DEF company");
            }
        }
        else if (getPreviousState() == States.PARTIALLY_DOWN) {
            if (getCurrentState() == States.OPERATIONAL) {
                System.out.println("Our server is operational now");
                setTwoServer(false);
            }
            else {
                System.out.println("Our server is fully down now");
                if (isTwoServer()) {
                    System.out.println("All our services have been shifted to the server of DEF");
                }
//                else {
//                    System.out.println("Our server (ABC) is fully down now");
//                }
            }
        }
        else {
            if (getCurrentState() == States.OPERATIONAL) {
                System.out.println("Our server is operational now");
                setTwoServer(false);
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

    public boolean isTwoServer() {
        return twoServer;
    }

    public void setTwoServer(boolean twoServer) {
        this.twoServer = twoServer;
    }
}
