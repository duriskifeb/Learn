package Project1.praTugasBesar;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import java.text.SimpleDateFormat;

class Ticket {
    private String eventName;
    private Date date;
    private double price;

    public Ticket(String eventName, Date date, double price) {
        this.eventName = eventName;
        this.date = date;
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}

class TicketPurchase {
    private ArrayList<Ticket> availableTickets;
    private ArrayList<Ticket> purchasedTickets;
    private ArrayList<String> purchaseHistory;

    public TicketPurchase() {
        availableTickets = new ArrayList<>();
        purchasedTickets = new ArrayList<>();
        purchaseHistory = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        availableTickets.add(ticket);
    }

    public void displayAvailableTickets() {
        System.out.println("Available Tickets:");
        for (int i = 0; i < availableTickets.size(); i++) {
            Ticket ticket = availableTickets.get(i);
            System.out.println((i + 1) + ". Event: " + ticket.getEventName() +
                    ", Date: " + ticket.getDate() +
                    ", Price: $" + ticket.getPrice());
        }
    }

    public void purchaseTicket(int ticketIndex) {
        if (ticketIndex >= 0 && ticketIndex < availableTickets.size()) {
            Ticket selectedTicket = availableTickets.get(ticketIndex);
            purchasedTickets.add(selectedTicket);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String purchaseInfo = "Purchased ticket for '" + selectedTicket.getEventName() + "' on " +
                    dateFormat.format(new Date()) + " at price: $" + selectedTicket.getPrice();

            purchaseHistory.add(purchaseInfo);

            // Remove the purchased ticket from available tickets
            availableTickets.remove(ticketIndex);
        } else {
            System.out.println("Invalid ticket index. Please select a valid ticket.");
        }
    }

    public void displayPurchaseHistory() {
        System.out.println("Purchase History:");
        for (String purchaseInfo : purchaseHistory) {
            System.out.println(purchaseInfo);
        }
    }

    public void displayPurchasedTickets() {
        System.out.println("Purchased Tickets:");
        for (Ticket ticket : purchasedTickets) {
            System.out.println("Event: " + ticket.getEventName() +
                    ", Date: " + ticket.getDate() +
                    ", Price: $" + ticket.getPrice());
        }
    }
}

public class Sekarepmu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a TicketPurchase object
        TicketPurchase ticketPurchase = new TicketPurchase();

        // Add some available tickets
        ticketPurchase.addTicket(new Ticket("Concert A", new Date(), 50.0));
        ticketPurchase.addTicket(new Ticket("Theater Show", new Date(), 40.0));

        // Display available tickets
        ticketPurchase.displayAvailableTickets();

        // Allow user to purchase tickets
        System.out.print("Enter the index of the ticket you want to purchase: ");
        int selectedTicketIndex = scanner.nextInt();
        ticketPurchase.purchaseTicket(selectedTicketIndex - 1); // Adjust for 0-based index

        // Display purchased tickets and purchase history
        ticketPurchase.displayPurchasedTickets();
        ticketPurchase.displayPurchaseHistory();

        // Close the scanner
        scanner.close();
    }
}
