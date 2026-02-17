package pl.edu.agh.mwo.mulitiplexReservationSystem;

import java.util.Objects;

public class Seat {

    private final String row;
    private final int number;

    public Seat(String row, int seatNumber) {
        this.row = row;
        this.number = seatNumber;
    }

    public String getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return number == seat.number && Objects.equals(row, seat.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, number);
    }

    @Override
    public String toString() {
        return "Seat: " + row + number;
    }
}
