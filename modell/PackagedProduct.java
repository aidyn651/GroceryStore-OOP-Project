package model;

public class PackagedProduct extends Product {
    private String brand;

    public PackagedProduct(int id, String name, double price, int quantity, String brand) {
        super(id, name, price, quantity);
        this.brand = brand;
    }

    @Override
    public void getCategory() {
        System.out.println("Category: Packaged");

    }
}