import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to place a new order?");
            System.out.println("1. New order");
            System.out.println("2. Exit");
            int inp = scn.nextInt();
            if (inp == 1) {
                HashMap<Coffee, Integer> orderList = new HashMap<>();

                while (true) {
                    System.out.println("What type of coffee would you like?");
                    System.out.println("1. Americano");
                    System.out.println("2. Espresso");
                    System.out.println("3. Cappuccino");
                    System.out.println("4. Mocha");
                    System.out.println("5. Exit");

                    inp = scn.nextInt();
                    if (inp >= 1 && inp <= 4) {
                        Coffee coffee;

                        if (inp == 1) {
                            coffee = new Coffee("Americano");
                        }
                        else if (inp == 2) {
                            coffee = new Coffee("Espresso");
                        }
                        else if (inp == 3) {
                            coffee = new Coffee("Cappuccino");
                        }
                        else {
                            coffee = new Coffee("Mocha");
                        }
                        System.out.println("How many cups do you want?");
                        int inp2 = scn.nextInt();
                        orderList.put(coffee, inp2);
                    }
                    else if (inp == 5) {
                        break;
                    }
                    else {
                        System.out.println("Invalid input! Try again.");
                    }

                }
                System.out.print("Thank you for your order. Your order is summarized below: ");
                System.out.println("(Name of the coffee followed by the ingredients used in preparing the coffee)");
                int totalPrice = 0;
                for (Map.Entry<Coffee, Integer> e : orderList.entrySet()) {
                    System.out.println(e.getValue() + " cup(s) of " + e.getKey().getDescription() + "\tBDT " +
                            e.getKey().getCost() + " * " + e.getValue() + " = " +
                            e.getValue() * e.getKey().getCost());
                    totalPrice += e.getValue() * e.getKey().getCost();
                }
                System.out.println("Total: BDT " + totalPrice);
            }
            else if (inp == 2) {
                break;
            }
            else {
                System.out.println("Invalid input! Try again.");
            }
        }
    }
}