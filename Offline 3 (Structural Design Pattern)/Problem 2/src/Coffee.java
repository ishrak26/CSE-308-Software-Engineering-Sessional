public class Coffee extends Beverage {
    Beverage beverage;

    public Coffee(String msg) {
        if (msg.equalsIgnoreCase("Americano")) {
            getAmericano();
        }
        else if (msg.equalsIgnoreCase("Espresso")) {
            getEspresso();
        }
        else if (msg.equalsIgnoreCase("Cappuccino")) {
            getCappuccino();
        }
        else if (msg.equalsIgnoreCase("Mocha")) {
            getMocha();
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

    private void getAmericano() {
        beverage = new Americano();
        beverage = new Water(beverage);
        beverage = new CoffeeBean(beverage);
        beverage = new CoffeeBean(beverage);
    }

    private void getEspresso() {
        beverage = new Espresso();
        beverage = new Water(beverage);
        beverage = new CoffeeBean(beverage);
        beverage = new DairyCream(beverage);
    }

    private void getCappuccino() {
        beverage = new Cappuccino();
        beverage = new Milk(beverage);
        beverage = new CoffeeBean(beverage);
        beverage = new CinnamonPowder(beverage);
    }

    private void getMocha() {
        beverage = new Mocha();
        beverage = new Milk(beverage);
        beverage = new CoffeeBean(beverage);
        beverage = new ChocolateSauce(beverage);
    }
}
