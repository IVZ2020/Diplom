package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/regAdmin", name="RegAdmin")
public class RegAdminServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/regAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        String adminLastName = req.getParameter("adminLastName");
        String adminLogin = req.getParameter("adminLogin");
        String adminPassword = req.getParameter("adminPassword");
        userService.registerNewAdmin( new User(adminName, adminLastName, adminLogin, adminPassword));
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }
}
