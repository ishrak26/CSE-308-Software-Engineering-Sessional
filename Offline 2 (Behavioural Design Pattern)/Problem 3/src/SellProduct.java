public class SellProduct implements State {
    VendingMachine vendingMachine;

    public SellProduct(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectMoney(int money) {
        System.out.println("Please wait for your product to being delivered...");
    }

    @Override
    public void returnMoney() {
        System.out.println("Please wait for your product to being delivered...");
    }

    @Override
    public void deliverProduct() {
        System.out.println("Thank you for purchasing from our vending machine!");
        System.out.println("Here is your product...");
        vendingMachine.deliver();
        System.out.println("Your product has been delivered.");
        vendingMachine.setCurrentBalance(0);
        if (vendingMachine.getProductCount() == 0) {
            vendingMachine.setState(vendingMachine.getSoldOutState());
            System.out.println("Oops! We are out of stock.");
        }
        else {
            vendingMachine.setState(vendingMachine.getWaitingForRequestState());
        }
    }

    @Override
    public void refillProduct(int productCount) {
        System.out.println("Vending machine is not empty yet...No refill required!");
    }
}
