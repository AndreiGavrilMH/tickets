package movie.tickets.query;

public class CustomerQuerys {
    public final static String GET_CUSTOMERS_SQL = "SELECT * FROM customers";
    public final static String ADD_CUSTOMER = "INSERT INTO customers(id,name,mobile,email) values (null,?,?,?)";
    public final static String DELETE_CUSTOMER = "DELETE FROM customers WHERE id =?";
}
