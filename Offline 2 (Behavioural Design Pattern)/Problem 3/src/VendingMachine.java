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

    public VendingMachine(int productCount, int productPrice) {
        this.productCount = productCount;
        this.productPrice = productPrice;

        waitingForRequestState = new WaitingForRequest(this);
        hasLessMoneyState = new HasLessMoney(this);
        hasMoreMoneyState = new HasLessMoney(this);
        sellProductState = new SellProduct(this);
        soldOutState = new SoldOut(this);

        if (productCount > 0) {
            state = waitingForRequestState;
        }
        else {
            state = soldOutState;
        }
    }

    public void deliverProduct() {
        if (productCount > 0) {
            productCount--;
        }
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
}
