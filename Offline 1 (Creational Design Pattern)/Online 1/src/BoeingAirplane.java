public class BoeingAirplane implements Airplane {
    private Engine engine = new BoeingEngine();
    private Wing wing = new BoeingWIng();

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public Wing getWing() {
        return wing;
    }

    @Override
    public String getManufacturer() {
        return "Boeing";
    }
}
