public class Corei9PC extends PC {
    @Override
    public void addProcessor() {
        processor = new Corei9();
        price += processor.getPrice();
    }

    @Override
    public void addCooler() {
        cooler = null;
    }

    @Override
    public void addDVDDrive() {
        dvdDrive = new DVDDrive();
        price += dvdDrive.getPrice();
    }

    @Override
    public String getName() {
        return "Intel 11th Generation Core i9 PC";
    }
}
