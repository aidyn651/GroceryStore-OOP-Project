package model;

public class FreshProduct extends Product {

    private int daysFresh;

    public FreshProduct(int productId, String name, double price,
                        int stockQuantity, int daysFresh) {
        super(productId, name, price, stockQuantity);
        setDaysFresh(daysFresh);
    }

    public int getDaysFresh() {
        return daysFresh;
    }

    public void setDaysFresh(int daysFresh) {
        if (daysFresh <= 0) {
            throw new IllegalArgumentException("Days fresh must be positive");
        }
        this.daysFresh = daysFresh;
    }

    @Override
    public String getProductType() {
        return "Fresh Product";
    }

    @Override
    public boolean isExpired() {
        return daysFresh <= 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", fresh days: " + daysFresh;
    }
}
