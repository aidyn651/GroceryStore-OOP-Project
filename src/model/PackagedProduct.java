package model;

public class PackagedProduct extends Product {

    private String expirationDate;

    public PackagedProduct(int productId, String name, double price,
                           int stockQuantity, String expirationDate) {
        super(productId, name, price, stockQuantity);
        setExpirationDate(expirationDate);
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        if (expirationDate == null || expirationDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Expiration date cannot be empty");
        }
        this.expirationDate = expirationDate;
    }

    @Override
    public String getProductType() {
        return "Packaged Product";
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", exp: " + expirationDate;
    }
}
