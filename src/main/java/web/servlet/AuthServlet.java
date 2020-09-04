package web.servlet;

import entity.User;
import service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/webapp/auth.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        User user = userService.authUser(login, pass);
        if (user != null) {
            req.getSession().setAttribute("currentUser", user);
            req.getSession().setAttribute("checkAuth", true);
            resp.sendRedirect("/");
        }
    }
}
