package com.aidyn.grocerystore;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Sale> sales = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Test data
        products.add(new Product(1, "Milk", 500, 10));
        products.add(new Product(2, "Bread", 300, 0));

        customers.add(new Customer(101, "Aida", "Regular", 90000));
        customers.add(new Customer(102, "Dana", "Gold", 150000));

        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> addCustomer();
                case 4 -> viewCustomers();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private static void showMenu() {
        System.out.println("""
                ===== GROCERY STORE SYSTEM =====
                1. Add Product
                2. View Products
                3. Add Customer
                4. View Customers
                0. Exit
                ================================
                Enter choice:
                """);
    }

    private static void addProduct() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        products.add(new Product(id, name, price, qty));
        System.out.println("Product added!");
    }

    private static void viewProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void addCustomer() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Level: ");
        String level = scanner.nextLine();

        System.out.print("Total purchases: ");
        double total = scanner.nextDouble();
        scanner.nextLine();

        customers.add(new Customer(id, name, level, total));
        System.out.println("Customer added!");
    }

    private static void viewCustomers() {
        for (Customer c : customers) {
            System.out.println(c);
            System.out.println("VIP: " + c.isVIP());
        }
    }
}
