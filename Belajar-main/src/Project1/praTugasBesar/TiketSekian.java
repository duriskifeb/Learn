package Project1.praTugasBesar;
import java.util.ArrayList;
import java.util.Scanner;

class Ticket {
    private String eventName;
    private int quantity;
    private double price;

    public Ticket(String eventName, int quantity, double price) {
        this.eventName = eventName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "eventName='" + eventName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class TicketManager {
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addTicket() {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Ticket ticket = new Ticket(eventName, quantity, price);
        ticketList.add(ticket);
        System.out.println("Ticket added successfully!");
    }

    public void viewTickets() {
        System.out.println("Ticket List:");
        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    public void updateTicket() {
        System.out.println("Choose ticket to update:");
        int index = 1;
        for (Ticket ticket : ticketList) {
            System.out.println(index + ". " + ticket.getEventName());
            index++;
        }

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice >= 1 && choice <= ticketList.size()) {
            Ticket selectedTicket = ticketList.get(choice - 1);
            System.out.print("Enter new quantity for " + selectedTicket.getEventName() + ": ");
            int newQuantity = scanner.nextInt();
            selectedTicket.setQuantity(newQuantity);
            System.out.println("Ticket updated successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void deleteTicket() {
        System.out.print("Enter the event name to delete: ");
        String eventName = scanner.nextLine();

        java.util.Iterator<Ticket> iterator = ticketList.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getEventName().equalsIgnoreCase(eventName)) {
                iterator.remove(); // Menggunakan iterator untuk menghapus elemen
                System.out.println("Ticket deleted successfully!");
                return;
            }
        }

        System.out.println("Ticket not found!");
    }
}

public class TiketSekian {
    public static void main(String[] args) {

        TicketManager ticketManager = new TicketManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTicket Management System");
            System.out.println("1. Add Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    ticketManager.addTicket();
                    break;
                case 2:
                    ticketManager.viewTickets();
                    break;
                case 3:
                    ticketManager.updateTicket();
                    break;
                case 4:
                    ticketManager.deleteTicket();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
