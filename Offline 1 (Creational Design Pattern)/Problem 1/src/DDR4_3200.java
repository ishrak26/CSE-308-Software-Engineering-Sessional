public class DDR4_3200 extends DDR4_RAM {
    @Override
    public int getPrice() {
        return 2950;
    }

    @Override
    public int getSpeed() {
        return 3200;
    }

    @Override
    public String getName() {
        return super.getName() + " 3200 MHz";
    }
}
