public class Corei7PC extends PC {
    @Override
    public void addProcessor() {
        processor = new Corei7();
        price += processor.getPrice();
    }

    @Override
    public void addCooler() {
        cooler = new LiquidCooler();
        price += cooler.getPrice();
    }

    @Override
    public void addDVDDrive() {
        dvdDrive = null;
    }

    @Override
    public String getName() {
        return "Intel 11th Generation Core i7 PC";
    }
}
