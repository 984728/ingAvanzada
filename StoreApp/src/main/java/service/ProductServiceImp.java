
package service;

import data.ProductDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import models.Product;

@Stateless
public class ProductServiceImp implements ProductService{
    
    @Inject
    private ProductDAO cDAO;

    @Override
    public List<Product> findAllProduct() {
        return cDAO.findAllProduct();
    }
    
    @Override
    public List<Product> findAllProduct(String filter) {
        return cDAO.findAllProduct(filter);
    }

    @Override
    public Product findProductbyId(Product product) {
        return cDAO.findProductbyId(product);
    }

    @Override
    public Product findProductbyEmail(Product product) {
        return cDAO.findProductbyEmail(product);
    }

    @Override
    public void insertProduct(Product product) {
        cDAO.insertProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        cDAO.deleteProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        cDAO.updateProduct(product);
    }
    
}

