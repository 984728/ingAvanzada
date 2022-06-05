
package service;

import data.CustomerDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import models.Customer;

@Stateless
public class CustomerServiceImp implements CustomerService{
    
    @Inject
    private CustomerDAO cDAO;

    @Override
    public List<Customer> findAllCustomer() {
        return cDAO.findAllCustomer();
    }
    
    @Override
    public List<Customer> findAllCustomer(String filter) {
        return cDAO.findAllCustomer(filter);
    }

    @Override
    public Customer findCustomerbyId(Customer customer) {
        return cDAO.findCustomerbyId(customer);
    }

    @Override
    public Customer findCustomerbyEmail(Customer customer) {
        return cDAO.findCustomerbyEmail(customer);
    }

    @Override
    public void insertCustomer(Customer customer) {
        cDAO.insertCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        cDAO.deleteCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        cDAO.updateCustomer(customer);
    }
    
}
