public class DairyCream extends CondimentDecorator {

    public DairyCream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return 40 + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Dairy Cream";
    }
}
