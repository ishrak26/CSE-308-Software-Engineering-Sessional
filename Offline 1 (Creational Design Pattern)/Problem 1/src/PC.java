import java.util.ArrayList;
import java.util.List;

public abstract class PC {
    protected List<RAM> rams;
    protected List<GraphicsCard> graphicsCards;
    protected int price;
    protected String name;
    protected Processor processor;
    protected Cooler cooler;
    protected DVDDrive dvdDrive;

    private final int BASE_PRICE = 70000;

    PC() {
        price = BASE_PRICE;
        rams = new ArrayList<>();
        graphicsCards = new ArrayList<>();
    }

    public abstract void addProcessor();

    public void addRAM(RAM ram) {
        rams.add(ram);
        price += ram.getPrice();
    }

    public void addGraphicsCard(GraphicsCard graphicsCard) {
        graphicsCards.add(graphicsCard);
        price += graphicsCard.getPrice();
    }

    public abstract void addCooler();

    public abstract void addDVDDrive();

    public List<RAM> getRAMs() {
        return rams;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public List<GraphicsCard> getGraphicsCards() {
        return graphicsCards;
    }

    public Cooler getCooler() {
        return cooler;
    }

    public DVDDrive getDVDDrive() {
        return dvdDrive;
    }

    public void print() {
        System.out.println("The details of this PC are listed below:");
        System.out.println("Name: " + getName());
        System.out.println("Processor: " + getProcessor().getName() + "\t\t" + getProcessor().getPrice() + " BDT");
        System.out.println("HDD: 1 TB, Motherboard" + "\t\t" + BASE_PRICE + " BDT");
        System.out.println("RAM(s):");
        for (RAM r:
             rams) {
            System.out.println(r.getName() + "\t\t" + r.getPrice() + " BDT");
        }
        System.out.println("Graphics Card(s):");
        for (GraphicsCard gc:
             graphicsCards) {
            System.out.println(gc.getName() + "\t\t" + gc.getPrice() + " BDT");
        }
        if (getCooler() != null) System.out.println("Cooler: " + getCooler().getName() + "\t\t" +
                getCooler().getPrice() + " BDT");
        if (getDVDDrive() != null) System.out.println("DVD Drive: " + getDVDDrive().getName()
                + "\t\t" + getDVDDrive().getPrice() + " BDT");
    }
}
