package com.aidyn.grocerystore;

public class FreshProduct extends Product {

    private int expirationDays;

    public FreshProduct(int id, String name, double price, int quantity, int expirationDays) {
        super(id, name, price, quantity);
        this.expirationDays = expirationDays;
    }
//setters
    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
    }

    @Override
    public void showInfo() {
        System.out.println("Fresh product: " + name +
                ", expires in " + expirationDays + " days");
    }
    // getters
    @Override
    public String getType() {
        return "Fresh";
    }
    public boolean isExpiringSoon() {
        return expirationDays <= 3;
    }
}
