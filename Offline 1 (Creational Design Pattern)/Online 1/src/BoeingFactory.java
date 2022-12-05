public class BoeingFactory implements AirplaneFactory {
    @Override
    public Airplane getAirplane() {
        return new BoeingAirplane();
    }
}
