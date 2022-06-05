package data;


import java.util.List;
import models.Product;

public interface ProductDAO {
    public List<Product> findAllProduct();
    public List<Product> findAllProduct(String filter);
    public Product findProductbyId(Product product);
    public Product findProductbyEmail(Product product);
    public void insertProduct(Product product);
    public void deleteProduct(Product product);
    public void updateProduct(Product product);
    
}