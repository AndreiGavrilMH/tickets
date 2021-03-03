package movie.tickets.query;

public class OrderQuerys {
    public final static String PLACE_ORDER_SQL = "INSERT INTO orders (id,customer_id,ticket_id,movie_title,no_of_tickets,price,date_of_order,active) values (NULL,?,?,?,?,?,?,?)";
    public final static String GET_PRICE_FOR_TICKETS_SQL = "SELECT price FROM tickets where movie_name = ? and date = ? and time = ?";
    public final static String MODIFY_TICKETS_SQL = "UPDATE tickets SET ticket_number = ticket_number - ? where movie_name = ? and date = ? and time = ?";
    public final static String SHOW_ORDERS_SQL = "SELECT * FROM orders WHERE active = 1";


}
