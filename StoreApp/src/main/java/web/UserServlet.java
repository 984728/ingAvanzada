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
import models.User;
import service.UserService;

@WebServlet(name = "UserServlet", urlPatterns = {"/store","/add","/delete"})
public class UserServlet extends HttpServlet {

    @Inject
    CustomerService cService;

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
            case "users":
                listUsers(request, response);
                break;
            case "/add":
                insertUser(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                //listAllCustomers(request, response);
                break;
        }
        listUsers(request, response);
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
                listUsers(request, response);
                break;
            case "/add":
                insertUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                listAllUsers(request, response);
                break;
        }
        listUsers(request, response);
        //return;

    }

    protected void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) {
            filter = "";
        }
        List<User> c = cService.findAllCustomer(filter);
        request.setAttribute("user", c);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
        return;
    }
    protected void listAllCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) {
            filter = "";
        }
        List<User> c = cService.findAllCustomer(filter);
        request.setAttribute("users", c);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
        return;
    }

    protected void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      User c = new User();
        c.setUserID(request.getParameter("userID"));
        c.setUserName(request.getParameter("userName"));
        c.setAddress(request.getParameter("address"));
        c.setCity(request.getParameter("city"));
        c.setState(request.getParameter("state"));
        c.setPhone(Long.parseLong(request.getParameter("phone")));
        c.setMobileno(Long.parseLong(request.getParameter("mobileno")));
        c.setEmail(request.getParameter("email"));
        c.setNotes("");
        cService.insertUser(c);
        request.setAttribute("message","User successfully added!");
        

    }

    protected void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User c = new User();
        String userId=request.getParameter("userId");
        c.setUserID(userId);
        System.out.println("delete.userId: "+userId);
        c= cService.findUserbyId(c);
        if (c != null) {
            cService.deleteUser(c);
            request.setAttribute("message", "User successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete User!");
        }
        
        
        //doGet(request, response);
    }
    
    protected void thorowUpdateCustomer(HttpServletRepuest request, HttpServletResponse response)
            throws ServletException, IOException{
        String filter = request.getParameter("filter");
        if (filter == null) filter="";
        List<User> u = uService.findIdUser(Integer.parseInt(filter));
        System.out.println();
        request.setAttribute("user",u);
        request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
        return;
    }
    
    protected void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User u = new User ();
        u.setId(integer.parseInt(request.getParameter("id")));
        u.setUser(request.getParameter("user"));
        u.setPwd(request.getParameter("pwd"));
        uService.updateUser(u);
        system.out.println(u.getUser());
        system.out.println(u.getPwd());
        request.setAttribute("message","User Successfully Update!");
        
        List<User> cus= uSerivice.findAllUser();
        request.setAttribute("User", cus);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
        return;
    }
}
}