public class GamingPC extends PC {

    @Override
    public void addProcessor() {
        processor = new AMDRyzen();
        price += processor.getPrice();
    }

    @Override
    public void addCooler() {
        cooler = null;
    }

    @Override
    public void addDVDDrive() {
        dvdDrive = null;
    }

    @Override
    public String getName() {
        return "AMD Ryzen Gaming PC";
    }
}
