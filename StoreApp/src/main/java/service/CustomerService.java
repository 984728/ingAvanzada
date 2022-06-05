
package service;

import java.util.List;
import models.Customer;
import models.User;

public interface CustomerService {
    public List<Customer> findAllCustomer();
    public List<Customer> findAllCustomer(String filtro);
    public List<Customer> findCustomerId(int filtro);
    public List<Customer> findCustomerId();
    public Customer findCustomerbyId(Customer customer);
    public Customer findCustomerbyEmail(Customer customer);
    public void insertCustomer(Customer customer);
    public void deleteCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void updateUser(User user);
}
