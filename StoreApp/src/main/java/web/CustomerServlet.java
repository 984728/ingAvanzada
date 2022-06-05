
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
import models.User;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/store","/add","/delete"})
public class CustomerServlet extends HttpServlet {

    @Inject
    CustomerService cService;
    CustomerService uService;
      
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
            case "customers":
                listCustomers(request, response);
                break;
            case "/add":
                insertCustomer(request, response);
                break;
            case "/delete":
                deleteCustomer(request, response);
                //listAllCustomers(request, response);
                break;
        }
        listCustomers(request, response);
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
            case "customers":
                listCustomers(request, response);
                break;
            case "/add":
                insertCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                listAllCustomers(request, response);
                break;
        }
        listCustomers(request, response);
        //return;

    }

    protected void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) {
            filter = "";
        }
        List<Customer> c = cService.findAllCustomer(filter);
        request.setAttribute("customers", c);
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
        return;
    }
    protected void listAllCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) {
            filter = "";
        }
        List<Customer> c = cService.findAllCustomer(filter);
        request.setAttribute("customers", c);
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
        return;
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
        request.setAttribute("message","Customer successfully added!");
        

    }

    protected void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer c = new Customer();
        String customerId=request.getParameter("customerId");
        c.setCustomerID(customerId);
        System.out.println("delete.customerId: "+customerId);
        c= cService.findCustomerbyId(c);
        if (c != null) {
            cService.deleteCustomer(c);
            request.setAttribute("message", "Customer successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete Customer!");
        }
        
        
        //doGet(request, response);
    }
    
    protected void thorowUpdateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String filter = request.getParameter("filter");
        if (filter == null) filter="";
        List<Customer> u = uService.findCustomerId(Integer.parseInt(filter));
        System.out.println();
        request.setAttribute("user",u);
        request.getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
        return;
    }
    
    protected void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = new User();
        u.setId(Integer.parseInt(request.getParameter("id")));
        u.setUser(request.getParameter("user"));
        u.setPwd(request.getParameter("pwd"));
        uService.updateUser(u);
        System.out.println(u.getUser());
        System.out.println(u.getPwd());
        request.setAttribute("message","Customer Successfully Update!");
        
        List<Customer> cus= uService.findAllCustomer();
        request.setAttribute("Customer", cus);
        request.getRequestDispatcher("/Customer.jsp").forward(request, response);
        return;
    }
}
