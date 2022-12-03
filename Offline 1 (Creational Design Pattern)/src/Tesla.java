public class Tesla implements Car {

    @Override
    public String getName() {
        return "Tesla";
    }

    @Override
    public String getCountry() {
        return "US";
    }

    @Override
    public String getContinent() {
        return "United States";
    }

    @Override
    public String getColor() {
        return "White";
    }

    @Override
    public String getEngine() {
        return "Electric Engine";
    }

    @Override
    public String getDriveTrain() {
        return "All wheels";
    }
}
