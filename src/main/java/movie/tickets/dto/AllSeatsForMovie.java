package movie.tickets.dto;

import java.time.LocalDate;

public class AllSeatsForMovie {
    private LocalDate date;
    private Integer roomNumber;
    private String letter;
    private Integer number;

    public AllSeatsForMovie(){}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public AllSeatsForMovie(LocalDate date, Integer roomNumber, String letter, Integer number) {
        this.date = date;
        this.roomNumber = roomNumber;
        this.letter = letter;
        this.number = number;
    }
}
