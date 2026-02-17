package pl.edu.agh.mwo.mulitiplexReservationSystem;

import java.util.ArrayList;
import java.util.List;

public class CinemaHall {

    private final int cinemaHallNumber;
    private final List<Seat> seats = new ArrayList<>();

    public CinemaHall(int cinemaHallNumber) {
        this.cinemaHallNumber = cinemaHallNumber;
    }
    public int getCinemaHallNumber() {
        return cinemaHallNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public Seat findSeatByNumber(String seatNumber) {
        String row = seatNumber.substring(0, 1);
        int number = Integer.parseInt(seatNumber.substring(1));
        for (Seat seat : seats) {
            if (seat.getRow().equals(row) && seat.getNumber() == number) {
                return seat;
            }
        }
        return null;
    }
}
