package pl.edu.agh.mwo.mulitiplexReservationSystem;

public class Movie {

    private final String title;
    private final String description;

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return  "Title: " + title + '\n' +
                "Description: " + description  + "\n";
    }
}
