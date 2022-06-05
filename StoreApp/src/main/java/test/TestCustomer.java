
package test;

import java.util.List;
import javax.persistence.*;
import models.Customer;

public class TestCustomer {

    public void insertCustomer() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DBStorePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Customer c = new Customer("5000", "Carlos", "Centro", "Neiva", "Huila", 123456, 4567890, "carlos@email.co", "");
        tx.begin();
        em.persist(c);
        tx.commit();
        em.close();
    }

    public void listCustomer() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("dbStoreJTAPU");
        EntityManager entitymanager = emfactory.createEntityManager();

        //Between
        Query query = entitymanager.createQuery("Select c " + "from Customer c " + "ORDER BY c.customerName ASC");
        List<Customer> list = (List<Customer>) query.getResultList();

        for (Customer c : list) {
            System.out.print("Curstomer ID :" + c.getCustomerID());
            System.out.println("\t Customer Name :" + c.getCustomerName());
        }

    }

}
