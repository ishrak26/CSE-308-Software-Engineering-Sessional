public class ChocolateSauce extends CondimentDecorator {

    public ChocolateSauce(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return 60 + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Chocolate Sauce";
    }
}
