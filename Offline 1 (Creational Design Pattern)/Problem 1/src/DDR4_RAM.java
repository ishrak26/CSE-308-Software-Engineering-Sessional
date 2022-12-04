public abstract class DDR4_RAM implements RAM {
    public abstract int getSpeed();

    @Override
    public int getStorageSize() {
        return 8;
    }

    @Override
    public String getName() {
        return "DDR4 RAM";
    }
}
