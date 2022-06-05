
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import service.UserService;

/**
 *
 * @author Usuario
 */
//@WebServlet(name = "Validate", urlPatterns = {"/validate"})
public class Validate extends HttpServlet {
    @Inject
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtUser");
            String pwd = request.getParameter("txtPwd");
            User userO = userService.validateUser(user, pwd);
            if (userO != null) {
                request.setAttribute("userO", userO);
                request.getRequestDispatcher("Controller?action=main").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
        }
        else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
