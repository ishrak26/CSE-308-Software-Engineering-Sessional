public class SellProduct implements State {
    VendingMachine vendingMachine;

    public SellProduct(VendingMachine vendingMachine) {
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
