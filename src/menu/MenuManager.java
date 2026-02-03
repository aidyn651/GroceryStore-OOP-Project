package menu;

import database.ProductDAO;
import model.*;

import java.util.Scanner;

public class MenuManager {

    private final Scanner scanner = new Scanner(System.in);
    private final ProductDAO dao = new ProductDAO();

    public void show() {
        while (true) {
            System.out.println("""
╔════════════════════════════════════╗
║        GROCERY MENU – WEEK 8       ║
╚════════════════════════════════════╝
1. Add Fresh Product
2. Add Packaged Product
3. View All Products
4. View Fresh Products Only
5. View Packaged Products Only
6. Update Product
7. Delete Product
8. Search by Name
9. Search by Price Range
10. High-Priced Products (>= X)
11. Polymorphism Demo
0. Exit
""");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addFresh();
                case 2 -> addPackaged();
                case 3 -> dao.getAllProducts().forEach(System.out::println);
                case 4 -> dao.getAllFreshProducts().forEach(System.out::println);
                case 5 -> dao.getAllPackagedProducts().forEach(System.out::println);
                case 6 -> updateProduct();
                case 7 -> deleteProduct();
                case 8 -> searchByName();
                case 9 -> searchByRange();
                case 10 -> searchByMin();
                case 11 -> polymorphismDemo();
                case 0 -> { return; }
            }
        }
    }

    private void addFresh() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        System.out.print("Days fresh: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        dao.insertFreshProduct(
                new FreshProduct(1, name, price, stock, days)
        );
    }

    private void addPackaged() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        System.out.print("Expiration day: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        dao.insertPackagedProduct(
                new PackagedProduct(1, name, price, stock, exp)
        );
    }

    private void updateProduct() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product p = dao.getProductById(id);
        if (p == null) {
            System.out.println("❌ Not found");
            return;
        }

        System.out.println("Current: " + p);

        System.out.print("New name (Enter keep): ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) p.setName(name);

        System.out.print("New price (-1 keep): ");
        double price = scanner.nextDouble();
        if (price >= 0) p.setPrice(price);

        System.out.print("New stock (-1 keep): ");
        int stock = scanner.nextInt();
        if (stock >= 0) p.setStockQuantity(stock);

        if (p instanceof FreshProduct)
            dao.updateFreshProduct((FreshProduct) p);
        else
            dao.updatePackagedProduct((PackagedProduct) p);
    }

    private void deleteProduct() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product p = dao.getProductById(id);
        if (p == null) {
            System.out.println("❌ Not found");
            return;
        }

        System.out.println("Delete: " + p);
        System.out.print("Are you sure? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            dao.deleteProduct(id);
            System.out.println("✅ Deleted");
        }
    }

    private void searchByName() {
        System.out.print("Name: ");
        dao.searchByName(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void searchByRange() {
        System.out.print("Min: ");
        double min = scanner.nextDouble();
        System.out.print("Max: ");
        double max = scanner.nextDouble();
        dao.searchByPriceRange(min, max)
                .forEach(System.out::println);
    }

    private void searchByMin() {
        System.out.print("Min price: ");
        dao.searchByMinPrice(scanner.nextDouble())
                .forEach(System.out::println);
    }

    private void polymorphismDemo() {
        System.out.println("=== POLYMORPHISM DEMO ===");
        for (Product p : dao.getAllProducts()) {
            System.out.println(p);
            System.out.println("Expired: " + p.isExpired());
            System.out.println("Total value: " + p.getTotalValue());
            System.out.println("--------------------");
        }
    }
}
