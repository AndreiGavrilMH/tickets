package movie.tickets.dto;

import java.time.LocalDate;

public class ShowAllOrders {
    private Integer customerId;
    private Integer ticketId;
    private String movieTitle;
    private Integer price;
    private LocalDate dateOfOrder;
    private boolean active;

    public ShowAllOrders (){}

    public ShowAllOrders(Integer customerId, Integer ticketId, String movieTitle, Integer price, LocalDate dateOfOrder, boolean active) {
        this.customerId = customerId;
        this.ticketId = ticketId;
        this.movieTitle = movieTitle;
        this.price = price;
        this.dateOfOrder = dateOfOrder;
        this.active = active;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
