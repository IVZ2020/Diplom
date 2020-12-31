package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change/login", name = "ChangeUserLoginServlet")
public class ChangeUserLoginServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String newLogin = req.getParameter("newLogin");
        User userForChange = (User) req.getSession().getAttribute("userForChange");
        int userForChangeId = userForChange.getId();

        if (userService.changeUserLogin(newLogin, userForChangeId)) {
            userForChange.setLogin(newLogin);
        }
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (userForChangeId == (currentUser.getId()) && userForChange.getRole() == 2) {
            res.sendRedirect("/editAdminProfile");
        } else if (userForChange.getRole() == 1) {
            res.sendRedirect("/editUserProfile");
        } else {
            res.sendRedirect("/editUserProfile");
        }
    }
}