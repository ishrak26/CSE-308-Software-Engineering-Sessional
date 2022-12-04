import java.util.Scanner;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Scanner scn = new Scanner(System.in);

        do {
            System.out.println("Enter your continental location (Asia/Europe/United States): ");
            String input = scn.nextLine();
            Car car = carFactory.getCar(input);
            if (car == null) {
                System.out.println("Sorry, no car available in your location");
            }
            else {
                car.printCar();
            }

            System.out.println("Press Y/y to continue, any other key to terminate this program");
            input = scn.nextLine();
            if (!input.equalsIgnoreCase("Y")) break;
        } while (true);
    }
}
