public class Director {
    private Builder builder;

    public void buildPC(Builder builder) {
        this.builder = builder;
        this.builder.addProcessor();
        this.builder.addCooler();
        this.builder.addDVDDrive();
//        this.builder.addRAM();
//        this.builder.addGraphicsCard();
    }
}
