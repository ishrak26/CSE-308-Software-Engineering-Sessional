public class Corei5PC extends PC {

    @Override
    public void addProcessor() {
        processor = new Corei5();
        price += processor.getPrice();
    }

    @Override
    public void addCooler() {
        cooler = new CPUCooler();
    }

    @Override
    public void addDVDDrive() {
        dvdDrive = null;
    }

    @Override
    public String getName() {
        return "Intel 11th Generation Core i5 PC";
    }
}
