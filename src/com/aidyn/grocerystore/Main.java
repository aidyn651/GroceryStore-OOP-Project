package com.aidyn.grocerystore;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // polimor
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addFreshProduct();
                    break;
                case 3:
                    addPackagedProduct();
                    break;
                case 4:
                    viewAll();
                    break;
                case 5:
                    demonstratePolymorphism();
                    break;
                case 6:
                    viewFreshOnly();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n===== GROCERY STORE =====");
        System.out.println("1. Add Product");
        System.out.println("2. Add Fresh Product");
        System.out.println("3. Add Packaged Product");
        System.out.println("4. View All Products");
        System.out.println("5. Demonstrate Polymorphism");
        System.out.println("6. View Fresh Products Only");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
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

        products.add(new Product(id, name, price, qty));
        System.out.println("Product added");
    }

    private static void addFreshProduct() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int qty = scanner.nextInt();

        System.out.print("Expiration days: ");
        int days = scanner.nextInt();

        Product p = new FreshProduct(id, name, price, qty, days);
        products.add(p);

        System.out.println("Fresh product added");
    }

    private static void addPackagedProduct() {
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

        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        Product p = new PackagedProduct(id, name, price, qty, brand);
        products.add(p);

        System.out.println("Packaged product added");
    }

    private static void viewAll() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\nPOLYMORPHISM DEMO:");
        for (Product p : products) {
            p.showInfo(); // один метод — разное поведение
        }
    }

    private static void viewFreshOnly() {
        System.out.println("\nFRESH PRODUCTS:");
        for (Product p : products) {
            if (p instanceof FreshProduct) {
                FreshProduct fp = (FreshProduct) p;
                fp.showInfo();

                if (fp.isExpiringSoon()) {
                    System.out.println("⚠ Expiring soon!");
                }
            }
        }
    }
}
