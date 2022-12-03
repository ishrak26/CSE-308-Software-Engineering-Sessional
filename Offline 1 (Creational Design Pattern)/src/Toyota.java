public class Toyota implements Car {

    @Override
    public String getName() {
        return "Toyota";
    }

    @Override
    public String getCountry() {
        return "Japan";
    }

    @Override
    public String getContinent() {
        return "Asia";
    }

    @Override
    public String getColor() {
        return "Red";
    }

    @Override
    public String getEngine() {
        return "Hydrogen fuel cell";
    }

    @Override
    public String getDriveTrain() {
        return "Rear-wheel";
    }
}
