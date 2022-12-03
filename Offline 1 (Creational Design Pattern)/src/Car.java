public interface Car {
    String getName();
    String getCountry();
    String getContinent();
    String getColor();
    String getEngine();
    String getDriveTrain();
    default void printCar() {
        System.out.println("Company: " + getName());
        System.out.println("Country: " + getCountry());
        System.out.println("Continent: " + getContinent());
        System.out.println("Color: " + getColor());
        System.out.println("Engine: " + getEngine());
        System.out.println("Drive Train: " + getDriveTrain());
    }
}
