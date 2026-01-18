package model;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreMenu implements Menu {
    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n===== GROCERY STORE MENU =====");
        System.out.println("1. Add Packaged Product");
        System.out.println("2. Add Fresh Product");
        System.out.println("3. View All Products");
        System.out.println("4. Show Product Categories");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addPackagedProduct();
                    case 2 -> addFreshProduct();
                    case 3 -> viewProducts();
                    case 4 -> showCategories();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addPackagedProduct() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        products.add(new PackagedProduct(id, name, price, quantity, brand));
        System.out.println("Packaged product added!");
    }

    private void addFreshProduct() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("ExpirationDays: ");
        int expirationDays = Integer.parseInt(scanner.nextLine());


        products.add(new FreshProduct(id, name, price, quantity, expirationDays));
        System.out.println("Fresh product added!");
    }

    private void viewProducts() {
        for (Product p : products) {
            p.displayInfo();
        }
    }

    private void showCategories() {
        for (Product p : products) {
            p.getCategory(); // polymorphism
        }
    }
}