package model;

public class FreshProduct extends Product {

    private int expirationDays;

    public FreshProduct(int id, String name, double price, int quantity, int expirationDays) {
        super(id, name, price, quantity);
        this.expirationDays = expirationDays;
    }
    @Override
    public void getCategory() {
        System.out.println("Category: Fresh");
    }
}