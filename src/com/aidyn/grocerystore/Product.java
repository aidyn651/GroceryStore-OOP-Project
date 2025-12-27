package com.aidyn.grocerystore;
public class Product {

    private int productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
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

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown product";
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        } else {
            this.stockQuantity = 0;
        }
    }

    // Logic
    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public void restock(int amount) {
        if (amount > 0) {
            stockQuantity += amount;
        }
    }

    @Override
    public String toString() {
        return productId + " | " + name + " | " + price + " KZT | qty: " + stockQuantity;
    }
}
