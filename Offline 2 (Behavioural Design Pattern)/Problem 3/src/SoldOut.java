public class SoldOut implements State {
    VendingMachine vendingMachine;

    public SoldOut(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectMoney(int money) {
        System.out.println("Oops! We are currently out of stock.");
    }

    @Override
    public void returnMoney() {
        System.out.println("Oops! We are currently out of stock.");
    }

    @Override
    public void deliverProduct() {
        System.out.println("Oops! We are currently out of stock.");
    }

    @Override
    public void refillProduct(int productCount) {
        System.out.println("Vending machine is being refilled...");
        vendingMachine.setProductCount(productCount);
        vendingMachine.setState(vendingMachine.getWaitingForRequestState());
    }
}
