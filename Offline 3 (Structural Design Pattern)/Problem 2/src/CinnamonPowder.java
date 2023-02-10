public class CinnamonPowder extends CondimentDecorator {

    public CinnamonPowder(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return 50 + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Cinnamon Powder";
    }
}
