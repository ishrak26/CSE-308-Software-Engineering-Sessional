public class DDR4_2666 extends DDR4_RAM {

    @Override
    public int getPrice() {
        return 2620;
    }

    @Override
    public int getSpeed() {
        return 2666;
    }

    @Override
    public String getName() {
        return super.getName() + " 2666 MHz";
    }
}
