public class WaitingForRequest implements State {
    VendingMachine vendingMachine;

    public WaitingForRequest(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectMoney(int money) {
        System.out.println("Your payment of BDT " + money + " is being processed...");
        vendingMachine.setCurrentBalance(vendingMachine.getCurrentBalance() + money);
        if (vendingMachine.getCurrentBalance() == vendingMachine.getProductPrice()) {
            vendingMachine.setState(vendingMachine.getSellProductState());
        }
        else if (vendingMachine.getCurrentBalance() < vendingMachine.getProductPrice()) {
            vendingMachine.setState(vendingMachine.getHasLessMoneyState());
        }
        else {
            vendingMachine.setState(vendingMachine.getHasMoreMoneyState());
        }
    }

    @Override
    public void returnMoney() {
        System.out.println("Please pay some money to get return...");
    }

    @Override
    public void deliverProduct() {
        System.out.println("Please pay first to get your product...");
    }

    @Override
    public void refillProduct() {
        System.out.println("Machine is non-empty! No refill currently needed!");
    }
}
