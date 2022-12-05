public class FactoryProducer {
    public AirplaneFactory getAirplane(String msg) {
        if (msg.equalsIgnoreCase("Boeing")) {
            return new BoeingFactory();
        }
        else if (msg.equalsIgnoreCase("Airbus")) {
            return new AirbusFactory();
        }
        else if (msg.equalsIgnoreCase("Safran")) {
            return new SafranFactory();
        }
        return null;
    }
}
