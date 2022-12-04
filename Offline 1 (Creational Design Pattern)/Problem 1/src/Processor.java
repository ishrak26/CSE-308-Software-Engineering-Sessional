public abstract class Processor implements Component {
    @Override
    public String getName() {
        return "Processor";
    }

    public abstract String getManufacturer();
}
