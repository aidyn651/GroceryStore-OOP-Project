package com.aidyn.grocerystore;

class GroceryStore{
    static void main(String[] args) {

        System.out.println("=== Grocery Store Management System ===");

        Product p1 = new Product(1, "Milk", 500, 10);
        Product p2 = new Product(2, "Bread", 300, 0);

        Customer c1 = new Customer(101, "Aida", "Regular", 90000);
        Customer c2 = new Customer(102, "Dana", "Gold", 150000);

        Sale sale1 = new Sale(1001, "Aida", 0, "2025-12-21");

        System.out.println("\n--- PRODUCTS ---");
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("\nIs Bread in stock? " + p2.isInStock());
        p2.restock(20);
        System.out.println("After restock: " + p2);

        System.out.println("\n--- CUSTOMERS ---");
        System.out.println(c1) ;
        System.out.println("Is VIP: " + c1.isVIP());
        System.out.println(c2);
        System.out.println("Is VIP: " + c2.isVIP());

        System.out.println("\n--- SALE ---");
        sale1.addItem(p1.getPrice());
        sale1.addItem(p2.getPrice());
        System.out.println(sale1);

        System.out.println("\n=== Program Complete ===");
    }
}


 class Product {

    private int productId;
    private String name;
    private double price;
    private int stockQuantity;



    public Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
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

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Methods with logic
    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public void restock(int amount) {
        stockQuantity += amount;
    }

    public String toString() {
        return "Product{id=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stockQuantity + '}';
    }
}


 class Customer {

    private int customerId;
    private String name;
    private String membershipLevel;
    private double totalPurchases;

    public Customer(int customerId, String name, String membershipLevel, double totalPurchases) {
        this.customerId = customerId;
        this.name = name;
        this.membershipLevel = membershipLevel;
        this.totalPurchases = totalPurchases;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    // Setters
    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    // Methods with logic
    public void addPurchase(double amount) {
        totalPurchases += amount;
    }

    public boolean isVIP() {
        return totalPurchases > 100000;
    }

    @Override
    public String toString() {
        return "Customer{id=" + customerId +
                ", name='" + name + '\'' +
                ", level='" + membershipLevel + '\'' +
                ", purchases=" + totalPurchases + '}';
    }
}


 class Sale {

    private int saleId;
    private String customerName;
    private double totalAmount;
    private String date;

    public Sale(int saleId, String customerName, double totalAmount, String date) {
        this.saleId = saleId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.date = date;
    }

    // Getters
    public int getSaleId() {
        return saleId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Methods with logic
    public void addItem(double price) {
        totalAmount += price;
    }

    public double calculateTotal() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Sale{id=" + saleId +
                ", customer='" + customerName + '\'' +
                ", total=" + totalAmount +
                ", date='" + date + '\'' + '}';
    }
}
