import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvoiceServiceDAO {

    public boolean addServiceToInvoice(InvoiceService invoiceService) {
        String query = "INSERT INTO invoice_services (invoice_id, service_id, hours, hourly_rate) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            
            ps.setInt(1, invoiceService.getInvoiceId());
            ps.setInt(2, invoiceService.getServiceId());
            ps.setDouble(3, invoiceService.getHours());
            ps.setDouble(4, invoiceService.getHourlyRate());
            
            int result = ps.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
}
