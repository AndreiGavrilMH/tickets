package movie.tickets.controller;

import movie.tickets.model.Customers;
import movie.tickets.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<Customers> getCustomers(){
        return customerService.getCustomers();
    }
    @PostMapping("/addCustomer")
    public Customers addCustomer(@RequestBody @Valid Customers c){
        return customerService.addCustomers(c);
    };

    @DeleteMapping("/deleteCustomer")
    public List<Customers> deleteCustomerById(@RequestParam int id){
        return customerService.deleteCustomerById(id);
    }
}
