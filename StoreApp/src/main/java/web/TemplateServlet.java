
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
import models.Customer;
import service.CustomerService;

@WebServlet(name = "StoreServlet", urlPatterns = {"/store","/insert"})
public class TemplateServlet extends HttpServlet {

    @Inject
    CustomerService cService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); 
        System.out.println("Entra a doPost");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action:" + action);
        switch (action) {
            case "customers":
                listCustomers(request, response);
                break;
            case "insert":
                insertCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            
        }
        listCustomers(request, response);

    }
    
    protected void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if(filter==null) filter="";
        List<Customer> c= cService.findAllCustomer(filter);
        request.setAttribute("customers", c);
        request.getRequestDispatcher("customers.jsp").forward(request, response);
    }
    
    protected void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer c = new Customer();
        c.setCustomerID(request.getParameter("customerID"));
        c.setCustomerName(request.getParameter("customerName"));
        c.setAddress(request.getParameter("address"));
        c.setCity(request.getParameter("city"));
        c.setState(request.getParameter("state"));
        c.setPhone(Long.parseLong(request.getParameter("phone")));
        c.setMobileno(Long.parseLong(request.getParameter("mobileno")));
        c.setEmail(request.getParameter("email"));
        c.setNotes("");
        cService.insertCustomer(c);
        
    }
    
    protected void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
        
        
    }
    

    

}
