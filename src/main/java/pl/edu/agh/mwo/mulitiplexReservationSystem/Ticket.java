package pl.edu.agh.mwo.mulitiplexReservationSystem;

import java.time.format.DateTimeFormatter;

public class Ticket {

    private final Customer customer;
    private final Seat seat;
    private final TicketStatus status;
    private final Screening screening;

    public Ticket(Customer customer, Seat seat, TicketStatus status, Screening screening) {
        this.customer = customer;
        this.seat = seat;
        this.status = status;
        this.screening = screening;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Seat getSeat() {
        return seat;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Screening getScreening() {
        return screening;
    }

    public void printTicket() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        String customerInformationOnTicket = (customer != null)
                ? customer.getFirstName() + " " + customer.getLastName() : "Guest";

        return "----- CINEMA TICKET -----\n" +
                "Movie: " + screening.getMovie().getTitle() + "\n" +
                "Date: " + screening.getScreeningStartTime().format(formatter) + "\n" +
                "Hall: " + screening.getCinemaHall().getCinemaHallNumber() + "\n" +
                "Seat: " + seat.getRow() + seat.getNumber() + "\n" +
                "Type: " + screening.getScreeningType() + "\n" +
                "Status: " + status + "\n" +
                "Customer: " + customerInformationOnTicket + "\n" +
                "-------------------------";
    }
}
