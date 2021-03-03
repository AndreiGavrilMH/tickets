package movie.tickets.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public class Tickets {
    @Max(15)
    private Integer ticketNumber;
    private String movieName;
    @NotNull(message = "Please add a price or 0 if movie is not available")
    private Integer price;
    private LocalDate date;
    private LocalTime time;
    private Integer id;

    public Tickets() {
    }

    public Tickets(Integer ticketNumber, String movieName, Integer price, LocalDate date, LocalTime time, Integer id) {
        this.ticketNumber = ticketNumber;
        this.movieName = movieName;
        this.price = price;
        this.date = date;
        this.time = time;
        this.id = id;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
