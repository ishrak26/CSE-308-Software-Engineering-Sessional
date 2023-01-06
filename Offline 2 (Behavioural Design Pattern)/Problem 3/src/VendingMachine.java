import java.util.Scanner;

public class VendingMachine {
    State waitingForRequestState;
    State hasLessMoneyState;
    State hasMoreMoneyState;
    State sellProductState;
    State soldOutState;

    State state;
    int productCount;
    int productPrice;
    int currentBalance = 0;

    Scanner scn;

    public VendingMachine(int productCount, int productPrice) {
        this.productCount = productCount;
        this.productPrice = productPrice;

        waitingForRequestState = new WaitingForRequest(this);
        hasLessMoneyState = new HasLessMoney(this);
        hasMoreMoneyState = new HasMoreMoney(this);
        sellProductState = new SellProduct(this);
        soldOutState = new SoldOut(this);

        if (productCount > 0) {
            state = waitingForRequestState;
        }
        else {
            state = soldOutState;
        }

        scn = new Scanner(System.in);
    }

    public void deliver() {
        if (productCount > 0) {
            productCount--;
        }
    }

    public void display() {
        System.out.println("No. of products: " + getProductCount());
        System.out.println("Product price: " + getProductPrice());
        System.out.println("Current balance: " + getCurrentBalance());
    }

    public void collectMoney() {
        System.out.println("Enter your payment (in BDT):");
        int money = scn.nextInt();
        state.collectMoney(money);
    }

    public void returnMoney() {
        state.returnMoney();
    }

    public void deliverProduct() {
        state.deliverProduct();
    }

    public void refillProduct(int productCount) {
        state.refillProduct(productCount);
    }

    public State getWaitingForRequestState() {
        return waitingForRequestState;
    }

    public State getHasLessMoneyState() {
        return hasLessMoneyState;
    }

    public State getHasMoreMoneyState() {
        return hasMoreMoneyState;
    }

    public State getSellProductState() {
        return sellProductState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getState() {
        return state;
    }

    public int getProductCount() {
        return productCount;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isEmpty() {
        return getProductCount() == 0;
    }
}
