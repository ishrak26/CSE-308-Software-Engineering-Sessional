public class GamingPCBuilder implements Builder {
    private PC gamingPC = new GamingPC();

    @Override
    public void addProcessor() {
        gamingPC.addProcessor();
    }

    @Override
    public void addRAM(RAM ram) {
        gamingPC.addRAM(ram);
    }

    @Override
    public void addGraphicsCard(GraphicsCard graphicsCard) {
        gamingPC.addGraphicsCard(graphicsCard);
    }

    @Override
    public void addCooler() {
        gamingPC.addCooler();
    }

    @Override
    public void addDVDDrive() {
        gamingPC.addDVDDrive();
    }

    @Override
    public PC getPC() {
        return gamingPC;
    }
}
