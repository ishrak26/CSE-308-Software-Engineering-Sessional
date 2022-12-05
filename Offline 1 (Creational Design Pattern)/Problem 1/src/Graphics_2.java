public class Graphics_2 extends GraphicsCard {

    @Override
    public int getPrice() {
        return 6500;
    }

    @Override
    public int getStorage() {
        return 2;
    }

    @Override
    public String getName() {
        return super.getName() + " 2 GB";
    }
}
