package test;

import database.DatabaseConnection;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("✅ JDBC CONNECTION CREATED");
        } else {
            System.out.println("❌ JDBC CONNECTION FAILED");
        }
    }
}
