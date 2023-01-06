import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ABCServer abcServer = new ABCServer();
        PremiumUser premiumUser = new PremiumUser(abcServer);
        RegularUser regularUser = new RegularUser(abcServer);

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Current state of the server is: " + abcServer.getServerState());
            System.out.println("Please choose one of the following options:");
            System.out.println("1. Change server state to Operational");
            System.out.println("2. Change server state to Partially Down");
            System.out.println("3. Change server state to Fully Down");
            System.out.println("4. Exit");

            int inp = scn.nextInt();
            if (inp == 1) {
                abcServer.changeState("Operational");
            }
            else if (inp == 2) {
                abcServer.changeState("Partially Down");
            }
            else if (inp == 3) {
                abcServer.changeState("Fully Down");
            }
            else if (inp == 4) {
                break;
            }
            else {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }
}