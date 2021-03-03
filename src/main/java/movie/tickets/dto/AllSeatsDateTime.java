package movie.tickets.dto;

public class AllSeatsDateTime {
    private String movieName;
    private Integer roomNumber;
    private String letter;
    private Integer number;

    public AllSeatsDateTime() {
    }

    public AllSeatsDateTime(String movieName, Integer roomNumber, String letter, Integer number) {
        this.movieName = movieName;
        this.roomNumber = roomNumber;
        this.letter = letter;
        this.number = number;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
}
