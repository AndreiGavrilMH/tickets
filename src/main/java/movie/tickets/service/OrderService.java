package movie.tickets.service;

import movie.tickets.dto.ShowAllOrders;
import movie.tickets.model.Orders;
import movie.tickets.query.TicketsQuerys;
import movie.tickets.repository.OrdersRepo;
import movie.tickets.utils.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String placeOrder (Orders orders){
        int checkMovie = jdbcTemplate.queryForObject(TicketsQuerys.CHECK_MOVIES_SQL, new Object[]{orders.getMovieTitle(),orders.getDate(),orders.getTime()}, Integer.class);
        if (checkMovie == 0){
            throw new ObjectNotFoundException("Could not make reservation! Please check the title, date and time");
        }
        return ordersRepo.placeOrder(orders);
    }

    public List<ShowAllOrders> showOrders(){ return ordersRepo.showOrders(); }



}
