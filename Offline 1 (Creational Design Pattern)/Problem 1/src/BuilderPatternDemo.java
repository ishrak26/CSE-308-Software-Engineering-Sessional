public class BuilderPatternDemo {
    public static void main(String[] args) {
        Director director = new Director();
        Builder gamingPCBuilder = new GamingPCBuilder();
        director.buildPC(gamingPCBuilder);
        PC pc = gamingPCBuilder.getPC();
        pc.print();
    }
}
