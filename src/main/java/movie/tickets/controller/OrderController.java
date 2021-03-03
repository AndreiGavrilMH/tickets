package movie.tickets.controller;

import movie.tickets.dto.ShowAllOrders;
import movie.tickets.model.Orders;
import movie.tickets.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Orders order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/showOrders")
    public List<ShowAllOrders> showOrders(){ return orderService.showOrders();}


}
