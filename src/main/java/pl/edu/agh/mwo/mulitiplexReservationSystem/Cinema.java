package pl.edu.agh.mwo.mulitiplexReservationSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private final String name;
    private final String address;

    private final List<Movie> movies = new ArrayList<>();
    private final List<Screening> screenings = new ArrayList<>();
    private final List<CinemaHall> cinemaHalls = new ArrayList<>();


    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public void addCinemaHall(CinemaHall cinemaHall) {
        cinemaHalls.add(cinemaHall);
    }

    public void printProgramme() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime weekLater = now.plusDays(7);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Programme for cinema: " + name);
        System.out.println("----------------------------------");

        for (Screening screening : screenings) {
            LocalDateTime start = screening.getScreeningStartTime();

            if (!start.isBefore(now) && !start.isAfter(weekLater)) {

                String date = start.format(dateFormatter);
                String time = start.format(timeFormatter);

                System.out.println(
                        screening.getMovie().getTitle() + " | " +
                                date + " | " +
                                time + " | Hall " +
                                screening.getCinemaHall().getCinemaHallNumber() + " | " +
                                screening.getScreeningType()
                );
            }
        }
        System.out.println("----------------------------------");
    }

    public Movie findMovie(String searchMovie) {
        for (Movie movie : getMovies()) {
            if (movie.getTitle().toLowerCase().contains(searchMovie.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    public void printScreeningsForMovie(Movie foundMovie) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        if (foundMovie == null) {
            System.out.println("Movie not found.");
            return;
        }
        System.out.println("\nAvailable screenings:");
        System.out.println("----------------------------------");
        for (Screening screening : screenings) {
            if (screening.getMovie().equals(foundMovie)) {
                LocalDateTime start = screening.getScreeningStartTime();
                String date = start.format(dateFormatter);
                String time = start.format(timeFormatter);
                System.out.println(
                        date + " | " + time + " | Hall " +
                                screening.getCinemaHall().getCinemaHallNumber() + " | " +
                                screening.getScreeningType()
                );
            }
        }
    }
}
