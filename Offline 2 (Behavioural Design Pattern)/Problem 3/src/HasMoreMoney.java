public class HasMoreMoney implements State {
    VendingMachine vendingMachine;

    public HasMoreMoney(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectMoney(int money) {
        System.out.println("Sorry, current balance already exceeds the product price. Please wait to get your return...");
    }

    @Override
    public void returnMoney() {
        System.out.println("Here is your return money...");
        vendingMachine.setCurrentBalance(vendingMachine.getProductPrice());
        System.out.println("Your product is now being delivered...");
        vendingMachine.setState(vendingMachine.getSellProductState());
        vendingMachine.deliverProduct();
    }

    @Override
    public void deliverProduct() {
        System.out.println("Please wait...You will get your return money first, and then the product.");
    }

    @Override
    public void refillProduct(int productCount) {
        System.out.println("Machine is non-empty...No refill currently required!");
    }
}
