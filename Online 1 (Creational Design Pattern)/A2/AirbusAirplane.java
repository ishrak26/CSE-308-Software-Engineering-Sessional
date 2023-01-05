public class AirbusAirplane implements Airplane {
    private Engine engine = new AirbusEngine();
    private Wing wing = new AirbusWing();

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
        return "AirBus";
    }
}
