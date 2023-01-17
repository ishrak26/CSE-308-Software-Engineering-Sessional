public class LongDiscount implements Discount {
    @Override
    public double getDiscount(int visit) {
        return 0.1;
    }
}
