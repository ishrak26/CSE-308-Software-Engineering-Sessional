public class Main {
    public static void main(String[] args) {
        Crewmate crewmate = new Crewmate();
        Imposter imposter = new Imposter();
        ImposterAdapter imposterAdapter = new ImposterAdapter(imposter);
        maintainSpaceship(crewmate);
        maintainSpaceship(imposterAdapter);
    }

    static void maintainSpaceship(Passenger passenger) {
        passenger.maintainSpaceship();
    }
}