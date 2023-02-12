public class BlackCoffee extends CondimentDecorator {
    public BlackCoffee(Beverage beverage) {
        this.beverage = new CoffeeBean(new Water(beverage));
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
