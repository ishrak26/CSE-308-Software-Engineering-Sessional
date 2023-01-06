public class HasLessMoney implements State {
    VendingMachine vendingMachine;

    public HasLessMoney(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectMoney(int money) {
        System.out.println("Your payment of BDT " + money + " is being processed...");
        vendingMachine.setCurrentBalance(vendingMachine.getCurrentBalance() + money);
        System.out.println("Product price is BDT " + vendingMachine.getProductPrice());
        System.out.println("Current balance is BDT " + vendingMachine.getCurrentBalance());
        if (vendingMachine.getCurrentBalance() == vendingMachine.getProductPrice()) {
            System.out.println("Your product is being delivered...");
            vendingMachine.setState(vendingMachine.getSellProductState());
            vendingMachine.deliverProduct();
        }
        else if (vendingMachine.getCurrentBalance() < vendingMachine.getProductPrice()) {
            System.out.println("Please pay BDT " + (vendingMachine.getProductPrice() - vendingMachine.getCurrentBalance()) +
                    " more to get your product.");
            vendingMachine.setState(vendingMachine.getHasLessMoneyState());
            vendingMachine.collectMoney();
        }
        else {
            System.out.println("Please wait...BDT " + (vendingMachine.getCurrentBalance() - vendingMachine.getProductPrice())
                    + " is being returned...");
            vendingMachine.setState(vendingMachine.getHasMoreMoneyState());
            vendingMachine.returnMoney();
        }
    }

    @Override
    public void returnMoney() {
        System.out.println("Your money is being returned...");
        vendingMachine.setCurrentBalance(0);
        vendingMachine.setState(vendingMachine.getWaitingForRequestState());
    }

    @Override
    public void deliverProduct() {
        System.out.println("You need to pay BDT " + vendingMachine.getProductPrice() + " in total to get your product.");
    }

    @Override
    public void refillProduct(int productCount) {
        System.out.println("Vending machine is not empty yet...No refill required.");
    }
}
