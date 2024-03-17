import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        testConnection();
    }

    private static void testConnection() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            System.out.println("Connected to the database successfully!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}