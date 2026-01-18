package model;

public class GroceryItem implements Sellable {

    private String name;
    private double price;
    private String supplier;
    private int stockAmount;

    //Setters
    public GroceryItem(String name, double price, String supplier, int stockAmount) {
        setName(name);
        setPrice(price);
        setSupplier(supplier);
        setStockAmount(stockAmount);
    }

    // Getters
    public String getProductName() {
        return name;
    }

    public double getUnitCost() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    // Setters with validation
    public void setName(String nme) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Product name must be at least 3 characters");
        }
        this.name = name;
    }

    public void setPrice(double price1) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        this.price = price;
    }

    public void setSupplier(String supplier) {
        if (supplier == null || supplier.trim().isEmpty()) {
            throw new IllegalArgumentException("Supplier cannot be empty");
        }
        this.supplier = supplier;
    }

    public void setStockAmount(int stockAmount) {
        if (stockAmount < 0) {
            throw new IllegalArgumentException("Stock amount cannot be negative");
        }
        this.stockAmount = stockAmount;
    }

    // Implementing Sellable interface
    @Override
    public void sell() {
        if (stockAmount <= 0) {
            System.out.println("❌ " + name + " is out of stock!");
            return;
        }
        stockAmount--;
        System.out.println("🛒 Selling " + name + "...");
        System.out.println("   Cost: " + price + " KZT");
        System.out.println("   Left in stock: " + stockAmount);
    }

    @Override
    public String getSupplierInfo() {
        return "Supplier: " + supplier;
    }

    // Other methods
    public void displayInfo() {
        System.out.println("Product: " + name);
        System.out.println("Cost: " + price + " KZT");
        System.out.println("Supplier: " + supplier);
        System.out.println("In stock: " + stockAmount);
    }

    @Override
    public String toString() {
        return name + " - " + price + " KZT (" + supplier + "), stock: " + stockAmount;
    }
}
