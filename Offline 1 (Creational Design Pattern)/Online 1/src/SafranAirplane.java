public class SafranAirplane implements Airplane {
    private Engine engine = new SafranEngine();
    private Wing wing = new SafranWing();

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
        return "Safran";
    }
}
