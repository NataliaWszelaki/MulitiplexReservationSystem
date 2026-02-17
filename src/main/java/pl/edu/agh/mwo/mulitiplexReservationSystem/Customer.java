package pl.edu.agh.mwo.mulitiplexReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final List<Ticket> tickets = new ArrayList<>();

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void printTickets() {
        System.out.println("Tickets for: " + firstName + " " + lastName);
        System.out.println("-----------------------------");
        if (tickets.isEmpty()) {
            System.out.println("No tickets.");
            return;
        }
        for (Ticket ticket : tickets) {
            ticket.printTicket();
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Customer: " + firstName + " " + lastName;
    }
}
