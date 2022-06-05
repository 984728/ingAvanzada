/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Customer;
import service.CustomerService;

public class Controller extends HttpServlet {

    @Inject
    CustomerService cService;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getParameter("action");
        System.out.println("Action Get:" + action);
        switch (action) {
            case "main":
                request.getRequestDispatcher("main.jsp").forward(request, response);
                break;
            case "customers":
                request.getRequestDispatcher("CustomerServlet?action=customers").forward(request, response);
                break;
            case "products":
                request.getRequestDispatcher("products.jsp").forward(request, response);
                break;
            case "sales":
                request.getRequestDispatcher("sales.jsp").forward(request, response);
                break;
            case "users":
                request.getRequestDispatcher("users.jsp").forward(request, response);
                break;
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "main":
                request.getRequestDispatcher("main.jsp").forward(request, response);
                break;
            case "customers":
                request.getRequestDispatcher("CustomerServlet?action=customers").forward(request, response);
                break;
            case "products":
                request.getRequestDispatcher("products.jsp").forward(request, response);
                break;
            case "sales":
                request.getRequestDispatcher("sales.jsp").forward(request, response);
                break;
            case "users":
                request.getRequestDispatcher("users.jsp").forward(request, response);
                break;
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    protected void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if(filter==null) filter="";
        List<Customer> c= cService.findAllCustomer(filter);
        request.setAttribute("customers", c);
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
    }

}
