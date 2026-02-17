package pl.edu.agh.mwo.mulitiplexReservationSystem;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Cinema cinema1 = new Cinema("Super Tarasy", "ul. Akademicka 5");
        Cinema cinema2 = new Cinema("Złote Tarasy", "ul. Złota 59");
        CinemaHall cinemaHall1 = new CinemaHall(1);
        CinemaHall cinemaHall2 = new CinemaHall(2);
        CinemaHall cinemaHall3 = new CinemaHall(3);

        Movie movie1 = new Movie("James Bond", "Film akcji");
        Movie movie2 = new Movie("Gra Endera", "Film sci-fi");
        Movie movie3 = new Movie("Wladca Pierścieni", "Film fantasy");
        Movie movie4 = new Movie("James Bond 2", "Film akcji");

        Screening screening1 = new Screening(
                movie1,
                cinemaHall1,
                LocalDateTime.of(2026, 2, 20, 18, 30),
                ScreeningType.THREE_D);
        Screening screening2 = new Screening(
                movie2,
                cinemaHall1,
                LocalDateTime.of(2026, 2, 21, 12, 20),
                ScreeningType.STANDARD);
        Screening screening3 = new Screening(
                movie3,
                cinemaHall2,
                LocalDateTime.of(2026, 2, 22, 8, 15),
                ScreeningType.VIP);
        Screening screening4 = new Screening(
                movie4,
                cinemaHall2,
                LocalDateTime.of(2026, 2, 22, 10, 10),
                ScreeningType.STANDARD
                );
        Screening screening5 = new Screening(
                movie2,
                cinemaHall3,
                LocalDateTime.of(2026, 2, 21, 10, 10),
                ScreeningType.STANDARD
                );

        cinemaHall1.addSeat(new Seat("A", 1));
        cinemaHall1.addSeat(new Seat("A", 2));
        cinemaHall1.addSeat(new Seat("B", 1));
        cinemaHall1.addSeat(new Seat("B", 2));

        cinemaHall2.addSeat(new Seat("A", 1));
        cinemaHall2.addSeat(new Seat("A", 2));
        cinemaHall2.addSeat(new Seat("B", 1));
        cinemaHall2.addSeat(new Seat("B", 2));

        cinema1.addMovie(movie1);
        cinema1.addMovie(movie2);
        cinema1.addMovie(movie3);
        cinema1.addMovie(movie4);

        cinema1.addCinemaHall(cinemaHall1);
        cinema1.addCinemaHall(cinemaHall2);

        cinema1.addScreening(screening1);
        cinema1.addScreening(screening2);
        cinema1.addScreening(screening3);
        cinema1.addScreening(screening4);

        cinema2.addCinemaHall(cinemaHall3);
        cinema2.addMovie(movie2);
        cinema2.addScreening(screening5);

        Customer customer1 = new Customer("Jan", "Kowalski", "jan@jan.pl");
        Customer customer2 = new Customer("Michał", "Nowak", "michal@gmail.com");

        // purchase tickets in advance
        System.out.println("\nBuying ticket with account (A1):");
        screening1.buyTicketWithAccount(customer1, "A1");

        // purchasing tickets without an account
        System.out.println("Buying ticket without account (A2):");
        screening1.buyTicketWithoutAccount("A2");

        // booking seats before the screening
        System.out.println("Reserving seats (B1, B2):");
        screening3.reserveSeats(customer2, "B1", "B2");

        System.out.println("\n--- ALL TICKETS FOR SCREENING ---");
        for (Ticket ticket : screening1.getTickets()) {
            ticket.printTicket();
            System.out.println();
        }

        for (Ticket ticket : screening3.getTickets()) {
            ticket.printTicket();
            System.out.println();
        }

        // ticket checks
        System.out.println("\n--- CUSTOMER TICKETS ---");
        customer1.printTickets();

        // check the repertoire for the next week
        System.out.println("\n--- PROGRAMME FOR NEXT WEEK FOR CINEMA 1 ---");
        cinema1.printProgramme();

        System.out.println("\n--- PROGRAMME FOR NEXT WEEK FOR CINEMA 2 ---");
        cinema2.printProgramme();

        //movie search
        System.out.println("\nSearching for movie: James Bond for cinema 1");
        Movie foundMovie = cinema1.findMovie("James Bond");
        cinema1.printScreeningsForMovie(foundMovie);

        System.out.println("\nSearching for movie: James Bond for cinema 2");
        Movie foundMovie2 = cinema2.findMovie("James Bond");
        cinema2.printScreeningsForMovie(foundMovie2);
    }
}
