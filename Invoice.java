import java.util.Date;

public class Invoice {
    private int id;
    private int clientId;
    private double totalAmount;
    private Date invoiceDate;
    private Date dueDate;
    private String status; 
  
    public Invoice() {}

    public Invoice(int id, int clientId, double totalAmount, Date invoiceDate, Date dueDate, String status) {
        this.id = id;
        this.clientId = clientId;
        this.totalAmount = totalAmount;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
