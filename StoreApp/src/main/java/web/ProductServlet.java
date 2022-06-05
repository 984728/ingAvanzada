package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Product;
import service.ProductService;

@WebServlet(name = "ProductServlet", urlPatterns = {"/store","/add","/delete"})
public class ProductServlet extends HttpServlet {

    @Inject
    ProductService cProduct;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);
        String action = request.getParameter("action");
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        System.out.println("Action CS:" + action);
        switch (action) {
            case "products":
                listProducts(request, response);
                break;
            case "/add":
                insertProduct(request, response);
                break;
            case "/delete":
                deleteProduct(request, response);
                //listAllCustomers(request, response);
                break;
        }
        listProducts(request, response);
        //return;
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        //System.out.println("Action CS:" + action);
        switch (action) {
            case "products":
                listProducts(request, response);
                break;
            case "/add":
                insertProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                listAllProducts(request, response);
                break;
        }
        listProducts(request, response);
        //return;

    }

    protected void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) {
            filter = "";
        }
        List<Product> c = cProduct.findAllProduct(filter);
        request.setAttribute("product", c);
        request.getRequestDispatcher("/product.jsp").forward(request, response);
        return;
    }
    protected void listAllCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) {
            filter = "";
        }
        List<Product> c = cProduct.findAllProduct(filter);
        request.setAttribute("products", c);
        request.getRequestDispatcher("/products.jsp").forward(request, response);
        return;
    }

    protected void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product c = new Product();
        c.setProductId(Integer.parseInt(request.getParameter("ProductId")));
        c.setProductName(request.getParameter("productName"));
     /*   c.setAddress(request.getParameter("address"));
        c.setCity(request.getParameter("city"));
        c.setState(request.getParameter("state"));
        c.setPhone(Long.parseLong(request.getParameter("phone")));
        c.setMobileno(Long.parseLong(request.getParameter("mobileno")));
        c.setEmail(request.getParameter("email")); */
        c.setNotes(""); 
        cProduct.insertProduct(c);
        request.setAttribute("message","Product successfully added!");
        

    }

    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product c = new Product();
        String productId=request.getParameter("productId");
        c.setproductId(productId);
        System.out.println("delete.productId: "+productId);
        c= cProduct.findProductbyId(c);
        if (c != null) {
            cProduct.deleteProduct(c);
            request.setAttribute("message", "Product successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete Product!");
        }
        
        
        //doGet(request, response);
    }

    protected void thorowUpdateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String filter = request.getParameter("filter");
        if (filter == null) filter="";
        List<Product> c = cProduct.findAllProduct(filter);
        System.out.println();
        request.setAttribute("product",c);
        request.getRequestDispatcher("/updateProduct.jsp").forward(request, response);
        return;
    }
    
    protected void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product c = new Product ();
        c.setProductId(Integer.parseInt(request.getParameter("id")));
        c.setProductName(request.getParameter("productName"));
        cProduct.updateProduct(c);
        System.out.println(c.getProductId());
        System.out.println(c.getProductName());
        request.setAttribute("message","Product Successfully Update!");
        
        List<Product> cus= cProduct.findAllProduct();
        request.setAttribute("Product", cus);
        request.getRequestDispatcher("/product.jsp").forward(request, response);
        return;
    }

    private void listAllProducts(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}