package model;

public abstract class Product {

    protected int productId;
    protected String name;
    protected double price;
    protected int stockQuantity;

    public Product(int productId, String name, double price, int stockQuantity) {
        setProductId(productId);
        setName(name);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // Setters with validation and exceptions
    public void setProductId(int productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        this.productId = productId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Product name must be at least 2 characters");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        this.stockQuantity = stockQuantity;
    }

    // Concrete method
    public double getTotalValue() {
        return price * stockQuantity;
    }

    // Abstract methods — ОБЯЗАТЕЛЬНО
    public abstract String getProductType();
    public abstract boolean isExpired();

    @Override
    public String toString() {
        return "[" + getProductType() + "] " + name +
                " (ID: " + productId + ") - " +
                price + " KZT, stock: " + stockQuantity;
    }
}
