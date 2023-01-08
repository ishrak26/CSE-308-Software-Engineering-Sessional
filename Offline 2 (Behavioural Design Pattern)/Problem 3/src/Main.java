import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Vending Machine.");
        System.out.println("Before starting...");
        System.out.println("Please set the product price");
        Scanner scn  = new Scanner(System.in);
        int productPrice = scn.nextInt();
        System.out.println("Please set the initial product count (>0)");
        int productCount = scn.nextInt();
        VendingMachine vendingMachine = new VendingMachine(productCount, productPrice);
        while (true) {
            System.out.println("Waiting for new order...");
            vendingMachine.display();
            System.out.println("Press 1 to proceed to payment, anything else to exit");
            int inp = scn.nextInt();
            if (inp == 1) {
                // order
                vendingMachine.collectMoney();

                if (vendingMachine.isEmpty()) {
                    System.out.println("Do you want to refill the vending machine?");
                    System.out.println("Press 1 to refill, anything else to exit");
                    inp = scn.nextInt();
                    if (inp == 1) {
                        System.out.println("Please enter how many products you want to load");
                        productCount = scn.nextInt();
                        vendingMachine.refillProduct(productCount);
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                break;
            }
        }
    }
}
