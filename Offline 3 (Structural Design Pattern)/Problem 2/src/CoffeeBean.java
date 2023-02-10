public class CoffeeBean extends CondimentDecorator {

    public CoffeeBean(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return 30 + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Grinded Coffee Beans";
    }
}
