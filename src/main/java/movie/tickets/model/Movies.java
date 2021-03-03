package movie.tickets.model;

import jdk.jfr.Timespan;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Movies {
    @NotNull(message = "Title cannot be null")
    private String title;
    @NotNull(message = "Genre cannot be null")
    private String genre;
    @NotNull(message = "Director cannot be null")
    private String director;
    @NotNull(message = "Date cannot be null")
    private LocalDate start;
    @Min(0)
    private Integer noOfTickets;
    @Min(0)
    private Integer price;
    @NotNull(message = "Please add the time of the movie")
    private LocalTime time;



    public Movies(){}

    public Movies(@NotNull(message = "Title cannot be null") String title, @NotNull(message = "Genre cannot be null") String genre, @NotNull(message = "Director cannot be null") String director, @NotNull(message = "Date cannot be null") LocalDate start, Integer noOfTickets, Integer price, LocalTime time) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.start = start;
        this.noOfTickets = noOfTickets;
        this.price = price;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public Integer getnoOfTickets() {
        return noOfTickets;
    }

    public void setnoOfTickets(Integer noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
