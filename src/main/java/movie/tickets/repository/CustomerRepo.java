package movie.tickets.repository;

import movie.tickets.model.Customers;
import movie.tickets.query.CustomerQuerys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customers> getCustomers(){
        return jdbcTemplate.query(CustomerQuerys.GET_CUSTOMERS_SQL, new BeanPropertyRowMapper<>(Customers.class));
    }

    public Customers addCustomers(Customers c) {
        jdbcTemplate.update(CustomerQuerys.ADD_CUSTOMER, c.getName(), c.getMobile(), c.getEmail());
        return c;
    }

    public List<Customers> deleteCustomerById(int id){
        try{
            jdbcTemplate.update(CustomerQuerys.DELETE_CUSTOMER,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
