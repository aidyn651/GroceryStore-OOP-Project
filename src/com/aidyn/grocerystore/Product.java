package com.aidyn.grocerystore;

public class Product {

    // protected accsess daug class
    protected int id;
    protected String name;
    protected double price;
    protected int quantity;

    // constr
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        setPrice(price);
        setQuantity(quantity);
    }

    // validation
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    // method for override
    public void showInfo() {
        System.out.println("Product: " + name);
    }

    // 2 method for override
    public String getType() {
        return "Product";
    }

    public boolean isInStock() {
        return quantity > 0;
    }

    @Override
    public String toString() {
        return "[" + getType() + "] " + name +
                " | Price: " + price +
                " | Qty: " + quantity;
    }
}
