package web.servlet;

import entity.User;
import lombok.Data;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/changeUserPasswordServlet", name = "ChangeUserPasswordServlet")
public class ChangeUserPasswordServlet  extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/password.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String newPassword = req.getParameter("newPassword");
        User userForChange = (User) req.getSession().getAttribute("userForChange");
        int userForChangeId = userForChange.getId();
        if (userService.changeUserPassword(newPassword, userForChangeId)) {
            userForChange.setPass(newPassword);
        }
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (userForChangeId == (currentUser.getId()) && userForChange.getRole() == 2) {
            res.sendRedirect("/editAdminProfile");
        } else if (userForChange.getRole() == 1 && currentUser.getRole() == 2) {
            res.sendRedirect("/getAllUsers");
        } else {
            res.sendRedirect("/editUserProfile");
        }
    }
}
