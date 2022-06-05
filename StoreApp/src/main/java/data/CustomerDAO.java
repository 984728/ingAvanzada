
package data;

import java.util.List;
import models.Customer;

public interface CustomerDAO {
    public List<Customer> findAllCustomer();
    public List<Customer> findAllCustomer(String filter);
    public Customer findCustomerbyId(Customer customer);
    public Customer findCustomerbyEmail(Customer customer);
    public void insertCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public void updateCustomer(Customer customer);
}