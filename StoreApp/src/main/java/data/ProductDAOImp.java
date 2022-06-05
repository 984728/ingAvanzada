package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import models.Product;

@Stateless //Indica que esta clase no permite crear objetos
public class ProductDAOImp implements ProductDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    @Override
    public List<Product> findAllProduct() {
        return em.createNamedQuery("customer.findAll").getResultList();
    }
    
    @Override
    public List<Product> findAllProduct(String filter) {
        Query query;
        query = em.createQuery("SELECT c FROM Customer c WHERE c.customerName LIKE :filter ORDER BY c.customerName");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList();
    }

    @Override
    public Product findProductbyId(Product product) {
        return em.find(Product.class, product.getProductID());
    }

    @Override
    public Product findProductbyEmail(Product product) {
        Query query =em.createQuery("select c from Customer c where c.email = :email");
        query.setParameter("email", product.getEmail());
        return (Product) query.getSingleResult();
        
    }

    @Override
    public void insertProduct(Product product) {
        try {
            em.persist(product);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
        
    }

    @Override
    public void deleteProduct(Product product) {
        em.remove(em.merge(product));
    }

    @Override
    public void updateProduct(Product product) {
        em.merge(product);        
    }
    
}

