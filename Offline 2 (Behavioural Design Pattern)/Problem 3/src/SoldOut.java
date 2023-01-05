public class SoldOut implements State {
    VendingMachine vendingMachine;

    public SoldOut(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectMoney(int money) {

    }

    @Override
    public void returnMoney() {

    }

    @Override
    public void deliverProduct() {

    }

    @Override
    public void refillProduct() {

    }
}
