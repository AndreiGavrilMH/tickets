package movie.tickets.model;

public class Room {
    private Integer roomNumber;
    private Integer seatId;

    public Room (){}

    public Room(Integer roomNumber, Integer seatId) {
        this.roomNumber = roomNumber;
        this.seatId = seatId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
}
