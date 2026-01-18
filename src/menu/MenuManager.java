package menu;

import model.FreshProduct;
import model.PackagedProduct;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Product> products;
    private Scanner scanner;

    public MenuManager() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);

        // add the data
        products.add(new PackagedProduct(1, "Rice", 2500, 10, "01.12.2026"));
        products.add(new FreshProduct(2, "Apple", 600, 30, 2));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n===== GROCERY STORE MENU =====");
        System.out.println("1. Add Packaged Product");
        System.out.println("2. Add Fresh Product");
        System.out.println("3. View All Products");
        System.out.println("4. Calculate Total Value");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
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
                    case 3 -> showProducts();
                    case 4 -> calculateTotalValue();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ===== MENU METHODS =====

    private void addPackagedProduct() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Expiration date: ");
        String expDate = scanner.nextLine();

        products.add(new PackagedProduct(id, name, price, qty, expDate));
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
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Days fresh: ");
        int daysFresh = Integer.parseInt(scanner.nextLine());

        products.add(new FreshProduct(id, name, price, qty, daysFresh));
        System.out.println("Fresh product added!");
    }

    private void showProducts() {
        System.out.println("\n--- PRODUCT LIST ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private void calculateTotalValue() {
       double total = 0;

        for (Product p : products) {
            total += p.getPrice() * p.getStockQuantity();
        }

        System.out.println("Total store value: " + total + " KZT");
    }
}
