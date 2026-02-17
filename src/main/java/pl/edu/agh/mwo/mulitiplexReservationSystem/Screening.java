package pl.edu.agh.mwo.mulitiplexReservationSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Screening {

    private final Movie movie;
    private final CinemaHall cinemaHall;
    private final LocalDateTime screeningStartTime;
    private final ScreeningType screeningType;
    private final List<Ticket> tickets = new ArrayList<>();

    public Screening(Movie movie, CinemaHall cinemaHall, LocalDateTime screeningStartTime, ScreeningType screeningType) {
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.screeningStartTime = screeningStartTime;
        this.screeningType = screeningType;
    }

    public Movie getMovie() {
        return movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public LocalDateTime getScreeningStartTime() {
        return screeningStartTime;
    }

    public ScreeningType getScreeningType() {
        return screeningType;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void buyTicketWithoutAccount(String ... seatNumbers) {
        processTickets(null, TicketStatus.BOUGHT, seatNumbers);
    }

    public void buyTicketWithAccount(Customer customer, String ... seatNumbers) {
        processTickets(customer, TicketStatus.BOUGHT, seatNumbers);
    }

    public void reserveSeats(Customer customer, String ... seatNumbers) {
        processTickets(customer, TicketStatus.RESERVED, seatNumbers);
    }

    private void processTickets(Customer customer, TicketStatus ticketStatus, String ... seatNumbers) {
        for (String seatNumber : seatNumbers) {
            Seat seat = cinemaHall.findSeatByNumber(seatNumber);
            if (seat == null) {
                System.out.println("Seat: " + seatNumber + " not found.");
                continue;
            }
            if (checkSeatAvailability(seat)) {
                Ticket ticket = new Ticket(customer, seat, ticketStatus, this);
                addTicket(ticket);
                if (customer != null) {
                    customer.addTicket(ticket);
                }
            } else {
                System.out.println("Seat: " + seatNumber + " is not available for this ticket.");
            }
        }
    }

    private boolean checkSeatAvailability(Seat seat) {
        for (Ticket ticket : tickets) {
            if (ticket.getSeat().equals(seat)) {
                return false;
            }
        }
        return true;
    }
}
