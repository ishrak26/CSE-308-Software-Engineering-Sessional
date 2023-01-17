public class LoyaltyDiscount implements Discount {
    @Override
    public double getDiscount(int visit) {
        return (visit/5) * 0.05;
    }
}
