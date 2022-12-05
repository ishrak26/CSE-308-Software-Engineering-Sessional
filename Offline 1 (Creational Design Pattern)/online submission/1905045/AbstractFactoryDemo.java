import java.util.Scanner;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        FactoryProducer factoryProducer = new FactoryProducer();
        Airplane airplane = null;
        do {
            System.out.println("Choose your preferred airplane company:");
            System.out.println("1. Boeing");
            System.out.println("2. AirBus");
            System.out.println("3. Safran");
            String input = scn.nextLine();
            if (input.equalsIgnoreCase("1")) {
                airplane = factoryProducer.getAirplane("Boeing").getAirplane();
                break;
            }
            else if (input.equalsIgnoreCase("2")) {
                airplane = factoryProducer.getAirplane("Airbus").getAirplane();
                break;
            }
            else if (input.equalsIgnoreCase("3")) {
                airplane = factoryProducer.getAirplane("Safran").getAirplane();
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        } while (true);
        System.out.println("Airplane details:");
        System.out.println("Manufacturer: " + airplane.getManufacturer());
        System.out.println("Engine: " + airplane.getEngine().getName());
        System.out.println("Wing: " + airplane.getWing().getName());


    }
}
