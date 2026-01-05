package com.aidyn.grocerystore;

public class PackagedProduct extends Product {
    private String brand;

    public PackagedProduct(int id, String name, double price, int quantity, String brand) {
        super(id, name, price, quantity);
        this.brand = brand;
    }

    @Override
    public void showInfo() {
        System.out.println("Packaged product: " + name +
                ", brand: " + brand);
    }

    @Override
    public String getType() {
        return "Packaged";
    }

    // Уникальный метод
    public String getBrand() {
        return brand;
    }
}
