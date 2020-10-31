package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change/lastName", name = "ChangeUserLastNameServlet")
public class ChangeUserLastNameServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/lastName.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String newLastName = req.getParameter("newLastName");
        String password = req.getParameter("password");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        int currentUserId = currentUser.getId();
        if (userService.changeUserLastName(newLastName, password, currentUserId)) {
            currentUser.setLastName(newLastName);
        }
        res.sendRedirect("/editAdminProfile");
    }
}