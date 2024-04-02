public class InvoiceService {
    private int invoiceServiceId;
    private int invoiceId;
    private int serviceId;
    private double hours;
    private double hourlyRate; 

    
    public InvoiceService() {}

    public InvoiceService(int invoiceId, int serviceId, double hours, double hourlyRate) {
        this.invoiceId = invoiceId;
        this.serviceId = serviceId;
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    public int getInvoiceServiceId() {
        return invoiceServiceId;
    }

    public void setInvoiceServiceId(int invoiceServiceId) {
        this.invoiceServiceId = invoiceServiceId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
