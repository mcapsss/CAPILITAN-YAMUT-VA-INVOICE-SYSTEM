import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {

    public boolean createInvoice(Invoice invoice) {
        String query = "INSERT INTO invoices (client_id, total_amount, invoice_date, due_date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setInt(1, invoice.getClientId());
            ps.setDouble(2, invoice.getTotalAmount());
            ps.setDate(3, new java.sql.Date(invoice.getInvoiceDate().getTime()));
            ps.setDate(4, new java.sql.Date(invoice.getDueDate().getTime()));
            ps.setString(5, invoice.getStatus());
            
            int result = ps.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Invoice> getInvoicesByClientId(int clientId) {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoices WHERE client_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setInt(1, clientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Invoice invoice = new Invoice();
                    invoice.setId(rs.getInt("invoice_id"));
                    invoice.setClientId(rs.getInt("client_id"));
                    invoice.setTotalAmount(rs.getDouble("total_amount"));
                    invoice.setInvoiceDate(rs.getDate("invoice_date"));
                    invoice.setDueDate(rs.getDate("due_date"));
                    invoice.setStatus(rs.getString("status"));
                    invoices.add(invoice);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

}
