package service;

import java.util.List;
import models.Product;

public interface ProductService {
    public List<Product> findAllProduct();
    public List<Product> findAllProduct(String filtro);
    public Product findProductbyId(Product product);
    public Product findCustomerbyEmail(Product product);
    public void insertCustomer(Product product);
    public void deleteCustomer(Product product);
    public void updateCustomer(Product product);

    public void insertProduct(Product c);

    public void deleteProduct(Product c);

    public void updateProduct(Product c);
    
}

