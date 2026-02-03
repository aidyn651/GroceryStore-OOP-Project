package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // ---------- CREATE (Week 7) ----------
    public boolean insertFreshProduct(FreshProduct p) {
        String sql = """
            INSERT INTO product
            (name, price, stock_quantity, product_type, days_fresh)
            VALUES (?, ?, ?, 'Fresh Product', ?)
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStockQuantity());
            ps.setInt(4, p.getDaysFresh());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertPackagedProduct(PackagedProduct p) {
        String sql = """
            INSERT INTO product
            (name, price, stock_quantity, product_type, expiration_day)
            VALUES (?, ?, ?, 'PACKAGED', ?)
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStockQuantity());
            ps.setInt(4, p.getExpirationDay());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ---------- READ ----------
    public Product getProductById(int id) {
        String sql = "SELECT * FROM product WHERE product_id=?";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractProduct(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY product_id";

        try (Connection c = DatabaseConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<FreshProduct> getAllFreshProducts() {
        List<FreshProduct> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_type='Fresh Product'";

        try (Connection c = DatabaseConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new FreshProduct(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity"),
                        rs.getInt("days_fresh")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<PackagedProduct> getAllPackagedProducts() {
        List<PackagedProduct> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_type='PACKAGED'";

        try (Connection c = DatabaseConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new PackagedProduct(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity"),
                        rs.getInt("expiration_day")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ---------- UPDATE (Week 8) ----------
    public boolean updateFreshProduct(FreshProduct p) {
        String sql = """
            UPDATE product
            SET name=?, price=?, stock_quantity=?, days_fresh=?
            WHERE product_id=? AND product_type='Fresh Product'
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStockQuantity());
            ps.setInt(4, p.getDaysFresh());
            ps.setInt(5, p.getProductId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePackagedProduct(PackagedProduct p) {
        String sql = """
            UPDATE product
            SET name=?, price=?, stock_quantity=?, expiration_day=?
            WHERE product_id=? AND product_type='PACKAGED'
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getStockQuantity());
            ps.setInt(4, p.getExpirationDay());
            ps.setInt(5, p.getProductId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ---------- DELETE (Week 8) ----------
    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE product_id=?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ---------- SEARCH (Week 8) ----------
    public List<Product> searchByName(String name) {
        List<Product> list = new ArrayList<>();
        String sql = """
            SELECT * FROM product
            WHERE name ILIKE ?
            ORDER BY name
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> searchByPriceRange(double min, double max) {
        List<Product> list = new ArrayList<>();
        String sql = """
            SELECT * FROM product
            WHERE price BETWEEN ? AND ?
            ORDER BY price DESC
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> searchByMinPrice(double min) {
        List<Product> list = new ArrayList<>();
        String sql = """
            SELECT * FROM product
            WHERE price >= ?
            ORDER BY price DESC
        """;

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractProduct(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ---------- HELPER ----------
    private Product extractProduct(ResultSet rs) throws SQLException {
        String type = rs.getString("product_type");

        if (type.equals("Fresh Product")) {
            return new FreshProduct(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("stock_quantity"),
                    rs.getInt("days_fresh")
            );
        } else {
            return new PackagedProduct(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("stock_quantity"),
                    rs.getInt("expiration_day")
            );
        }
    }
}
