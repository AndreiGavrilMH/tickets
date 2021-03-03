package movie.tickets.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Orders {
    private String movieTitle;
    private Integer noOfTickets;
    private LocalDate date;
    private LocalTime time;

    public Orders (){}

    public Orders(String movieTitle, Integer noOfTickets, LocalDate date, LocalTime time) {
        this.movieTitle = movieTitle;
        this.noOfTickets = noOfTickets;
        this.date = date;
        this.time = time;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Integer getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(Integer noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
