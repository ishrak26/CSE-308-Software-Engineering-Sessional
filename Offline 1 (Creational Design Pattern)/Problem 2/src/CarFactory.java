public class CarFactory {

    public Car getCar(String carLocation) {
        if (carLocation == null) {
            return null;
        }
        if (carLocation.equalsIgnoreCase("Asia")) {
            return new Toyota();
        }
        if (carLocation.equalsIgnoreCase("Europe")) {
            return new BMW();
        }
        if (carLocation.equalsIgnoreCase("United States")) {
            return new Tesla();
        }

        return null;
    }
}
