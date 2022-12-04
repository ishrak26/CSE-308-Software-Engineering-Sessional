public interface Builder {

    void addProcessor();
    void addRAM(RAM ram);
    void addGraphicsCard(GraphicsCard graphicsCard);
    void addCooler();
    void addDVDDrive();
    PC getPC();
}
