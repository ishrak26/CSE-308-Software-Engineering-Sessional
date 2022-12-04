public class BMW implements Car {

    @Override
    public String getName() {
        return "BMW";
    }

    @Override
    public String getCountry() {
        return "Germany";
    }

    @Override
    public String getContinent() {
        return "Europe";
    }

    @Override
    public String getColor() {
        return "Black";
    }

    @Override
    public String getEngine() {
        return "Electric Engine";
    }

    @Override
    public String getDriveTrain() {
        return "Rear-wheel";
    }
}
