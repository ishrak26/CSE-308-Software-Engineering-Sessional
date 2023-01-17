public class NoDiscount implements Discount {

    @Override
    public double getDiscount(int visit) {
        return 0;
    }
}
