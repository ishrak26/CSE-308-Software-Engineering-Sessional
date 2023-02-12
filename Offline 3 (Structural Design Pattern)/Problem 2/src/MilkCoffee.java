public class MilkCoffee extends CondimentDecorator {
    public MilkCoffee(Beverage beverage) {
        this.beverage = new CoffeeBean(new Milk(beverage));
    }

    @Override
    public int getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}
