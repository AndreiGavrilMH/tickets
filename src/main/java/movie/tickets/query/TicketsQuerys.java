package movie.tickets.query;

public class TicketsQuerys {
    public final static String REMOVE_TICKETS_SQL = "update tickets t join movies m on m.id = t.movie_id set ticket_number = ticket_number - ?, t.price = ? where m.title = ? and m.start = ? and m.time = ?;";
    public final static String INSERT_TICKETS_SQL = "INSERT INTO tickets (id,ticket_number,movie_name,date,time,price,movie_id) VALUES (NULL, ?,?,?,?,?,?);";
    public final static String ADD_TICKETS_SQL = "update tickets t join movies m on m.id = t.movie_id set ticket_number = ticket_number + ?, t.price = ? where m.title = ? and m.start = ? and m.time = ?;";
    public final static String CHECK_TITLE_SQL = "select count(*) from movies where title = ?";
    public final static String CHECK_TITLE_DATE_MOVIES_SQL = "select count(*) from movies where title = ? and start = ?";
    public final static String CHECK_TITLE_TIME_MOVIES_SQL = "select count(*) from movies where title = ? and time = ?";
    public final static String CHECK_MOVIES_SQL = "select count(*) from movies where title = ? and start = ? and time = ?";
    public final static String PRICE_FOR_DIRECTOR_SQL = "select sum(price*no_of_tickets) from movies where director = ?";
    public final static String SEE_ALL_MOVIES_TITLE_SQL = "select count(*) from movies where director = ?";
    public final static String ALL_AVAILABLE_SEATS_FOR_MOVIE_SQL = "select t.date,room_number,s.letter, s.number from tickets t join movie_showings ms on t.movie_id=ms.movie_id join room r on r.id = ms.cinema_id join seats s on s.id = r.seat_id where s.active=1 and t.movie_name = ? order by t.date, r.room_number,s.letter, t.movie_name LIMIT ?;";
    public final static String ALL_AVAILABLE_SEATS_FOR_DATE_SQL = "select t.movie_name,room_number,s.letter, s.number from tickets t join movie_showings ms on t.movie_id=ms.movie_id join room r on r.id = ms.cinema_id join seats s on s.id = r.seat_id where s.active=1 and t.date = ? order by t.date, r.room_number,s.letter, t.movie_name LIMIT ?;";
    public final static String ALL_AVAILABLE_SEATS_FOR_TIME_SQL = "select t.movie_name,room_number,s.letter, s.number from tickets t join movie_showings ms on t.movie_id=ms.movie_id join room r on r.id = ms.cinema_id join seats s on s.id = r.seat_id where s.active=1 and t.time = ? order by t.date, r.room_number,s.letter, t.movie_name LIMIT ?;";
    public final static String ALL_AVAILABLE_SEATS_FOR_DATETIME_SQL = "select t.movie_name,room_number,s.letter, s.number from tickets t join movie_showings ms on t.movie_id=ms.movie_id join room r on r.id = ms.cinema_id join seats s on s.id = r.seat_id where s.active=1 and t.date = ? and t.time = ? order by t.date, r.room_number,s.letter, t.movie_name LIMIT ?;";
    public final static String SET_LIMIT_SQL = "select sum(ticket_number) from tickets where movie_name = ?";
    public final static String SET_LIMIT_DATE_SQL = "select sum(ticket_number) from tickets where date = ? ";
    public final static String SET_LIMIT_TIME_SQL = "select sum(ticket_number) from tickets where time = ?";
    public final static String SET_LIMIT_DATETIME_SQL = "select sum(ticket_number) from tickets where date = ? and time = ?";
}
