package movie.tickets.model;

public class Seats {
    private String letter;
    private Integer number;

    public Seats (){}

    public Seats(String letter, Integer number) {
        this.letter = letter;
        this.number = number;
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
