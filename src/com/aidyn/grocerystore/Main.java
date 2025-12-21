package com.aidyn.grocerystore;

 class Main {
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
