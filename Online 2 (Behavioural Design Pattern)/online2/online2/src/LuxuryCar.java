public class LuxuryCar implements Car {
    private String type;
    private int visit = 0;
    private Discount discount;
    private int rentalDuration;

    public LuxuryCar() {
        discount = new NoDiscount();
        type = "Luxury";
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getVisit() {
        return visit;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    public void incVisit() {
        visit++;
        discount = new LoyaltyDiscount();
    }

    public void setRentalDuration(int dur) {
        rentalDuration = dur;
    }

    public double getPrice() {
        double price = 700 * rentalDuration;
        double disc = discount.getDiscount(visit);
        price *= disc;
        if (rentalDuration > 30) {
            price *= new LongDiscount().getDiscount(visit);
        }
        return price;
    }
}
