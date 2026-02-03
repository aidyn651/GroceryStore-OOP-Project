package model;

public class PackagedProduct extends Product {

    private int expirationDay;

    public PackagedProduct(int productId, String name, double price,
                           int stockQuantity, int expirationDay) {
        super(productId, name, price, stockQuantity);
        setExpirationDay(expirationDay);
    }

    public int getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(int expirationDay) {
        if (expirationDay <= 0) {
            throw new IllegalArgumentException("Expiration day must be positive");
        }
        this.expirationDay = expirationDay;
    }

    @Override
    public String getProductType() {
        return "PACKAGED";
    }

    // 🔥 ВОТ ЭТО ОБЯЗАТЕЛЬНО
    @Override
    public boolean isExpired() {
        return false;
    }
}
