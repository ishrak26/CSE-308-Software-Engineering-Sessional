public class AirbusFactory implements AirplaneFactory {
    @Override
    public Airplane getAirplane() {
        return new AirbusAirplane();
    }
}
