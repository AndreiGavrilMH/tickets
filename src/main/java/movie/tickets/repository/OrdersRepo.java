package movie.tickets.repository;

import movie.tickets.dto.ShowAllOrders;
import movie.tickets.model.Orders;
import movie.tickets.query.OrderQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class OrdersRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String placeOrder(Orders order) {
        int rand = ThreadLocalRandom.current().nextInt(1,99);
        Integer oneTicket = jdbcTemplate.queryForObject(OrderQuerys.GET_PRICE_FOR_TICKETS_SQL, new Object[]{order.getMovieTitle(), order.getDate(), order.getTime()}, Integer.class);
        Integer price = oneTicket * order.getNoOfTickets();
        jdbcTemplate.update(OrderQuerys.MODIFY_TICKETS_SQL,order.getNoOfTickets(),order.getMovieTitle(), order.getDate(), order.getTime());
        jdbcTemplate.update(OrderQuerys.PLACE_ORDER_SQL, 1, rand, order.getMovieTitle(), order.getNoOfTickets(), price, LocalDate.now(),1);
        return "Your order for "+order.getMovieTitle()+" has been placed! We await you on "+order.getDate()+", 20 minutes before "+order.getTime()+" for treats!";
    }

    public List<ShowAllOrders> showOrders(){
        return jdbcTemplate.query(OrderQuerys.SHOW_ORDERS_SQL,new BeanPropertyRowMapper<>(ShowAllOrders.class));
    }



}
