package movie.tickets.service;

import movie.tickets.model.Customers;
import movie.tickets.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customers> getCustomers(){
        return customerRepo.getCustomers();
    }

    public Customers addCustomers(Customers c) {
        return customerRepo.addCustomers(c);
    }

    public List<Customers> deleteCustomerById(int id){
        return customerRepo.deleteCustomerById(id);
    }
}
