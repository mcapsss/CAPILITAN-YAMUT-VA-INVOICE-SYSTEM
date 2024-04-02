import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ClientDAO clientDAO = new ClientDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nInvoice Management System:");
            System.out.println("1. Add Client");
            System.out.println("2. View Clients");
            System.out.println("3. Update Client");
            System.out.println("4. Delete Client");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    viewClients();
                    break;
                case 3:
                    updateClient();
                    break;
                case 4:
                    deleteClient();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addClient() {
        System.out.println("Add New Client:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();

        Client client = new Client(name, email, phone, address);
        boolean success = clientDAO.addClient(client);
        if (success) {
            System.out.println("Client added successfully.");
        } else {
            System.out.println("Failed to add client.");
        }
    }

    private static void viewClients() {
        List<Client> clients = clientDAO.getAllClients();
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            System.out.println("Clients:");
            for (Client client : clients) {
                System.out.println("ID: " + client.getId() + ", Name: " + client.getName() +
                        ", Email: " + client.getEmail() + ", Phone: " + client.getPhone() +
                        ", Address: " + client.getAddress());
            }
        }
    }

    private static void updateClient() {
        System.out.println("Update Client:");
        System.out.print("Enter Client ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();

        Client client = new Client(id, name, email, phone, address);
        boolean success = clientDAO.updateClient(client);
        if (success) {
            System.out.println("Client updated successfully.");
        } else {
            System.out.println("Failed to update client.");
        }
    }

    private static void deleteClient() {
        System.out.println("Delete Client:");
        System.out.print("Enter Client ID: ");
        int clientId = scanner.nextInt();

        boolean success = clientDAO.deleteClient(clientId);
        if (success) {
            System.out.println("Client deleted successfully.");
        } else {
            System.out.println("Failed to delete client.");
        }
    }
}
