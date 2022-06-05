
package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import models.Customer;

@Stateless //Indica que esta clase no permite crear objetos
public class CustomerDAOImp implements CustomerDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    @Override
    public List<Customer> findAllCustomer() {
        return em.createNamedQuery("customer.findAll").getResultList();
    }
    
    @Override
    public List<Customer> findAllCustomer(String filter) {
        Query query;
        query = em.createQuery("SELECT c FROM Customer c WHERE c.customerName LIKE :filter ORDER BY c.customerName");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList();
    }

    @Override
    public Customer findCustomerbyId(Customer customer) {
        return em.find(Customer.class, customer.getCustomerID());
    }

    @Override
    public Customer findCustomerbyEmail(Customer customer) {
        Query query =em.createQuery("select c from Customer c where c.email = :email");
        query.setParameter("email", customer.getEmail());
        return (Customer) query.getSingleResult();
        
    }

    @Override
    public void insertCustomer(Customer customer) {
        try {
            em.persist(customer);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
        
    }

    @Override
    public void deleteCustomer(Customer customer) {
        em.remove(em.merge(customer));
    }

    @Override
    public void updateCustomer(Customer customer) {
        em.merge(customer);        
    }
    
}
