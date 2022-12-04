public abstract class Builder {
    protected PC pc;

    void addProcessor() {
        pc.addProcessor();
    }

    public void addRAM(RAM ram) {
        pc.addRAM(ram);
    }

    public void addGraphicsCard(GraphicsCard graphicsCard) {
        pc.addGraphicsCard(graphicsCard);
    }

    void addCooler() {
        pc.addCooler();
    }

    void addDVDDrive() {
        pc.addDVDDrive();
    }

    public PC getPC() {
        return pc;
    }
}
