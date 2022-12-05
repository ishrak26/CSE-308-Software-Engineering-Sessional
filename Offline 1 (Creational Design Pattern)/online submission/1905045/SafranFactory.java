public class SafranFactory implements AirplaneFactory {
    @Override
    public Airplane getAirplane() {
        return new SafranAirplane();
    }
}
