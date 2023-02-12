public class Coffee extends Beverage {
    Beverage beverage;

    public Coffee(String msg) {
        if (msg.equalsIgnoreCase("Americano")) {
            beverage = getAmericano();
        }
        else if (msg.equalsIgnoreCase("Espresso")) {
            beverage = getEspresso();
        }
        else if (msg.equalsIgnoreCase("Cappuccino")) {
            beverage = getCappuccino();
        }
        else if (msg.equalsIgnoreCase("Mocha")) {
            beverage = getMocha();
        }
    }

    public Beverage getBeverage() {
        return beverage;
    }

    @Override
    public int getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    private Beverage getAmericano() {
        return new CoffeeBean(new BlackCoffee(new Americano()));
    }

    private Beverage getEspresso() {
        return new DairyCream(new BlackCoffee(new Espresso()));
    }

    private Beverage getCappuccino() {
        return new CinnamonPowder(new MilkCoffee(new Cappuccino()));
    }

    private Beverage getMocha() {
        return new ChocolateSauce(new MilkCoffee(new Mocha()));
    }
}
