package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/regUser", name="RegUser")
public class RegUserServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/regUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = (String) req.getAttribute("userName");
        String userLastName = (String) req.getAttribute("userLastName");
        String userLogin = (String) req.getAttribute("userLogin");
        String userPassword = (String) req.getAttribute("userPassword");
        userService.registerNewUser( new User(userName, userLastName, userLogin, userPassword));
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

}
