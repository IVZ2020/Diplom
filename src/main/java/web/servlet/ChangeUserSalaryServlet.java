package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/change/salary", name = "ChangeUserSalaryServlet")
public class ChangeUserSalaryServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/salary.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        double newSalary = Double.parseDouble(req.getParameter("newSalary"));
        User userForChange = (User) req.getSession().getAttribute("userForChange");
        int userForChangeId = userForChange.getId();
        if (userService.changeUserSalary(newSalary, userForChangeId)) {
            userForChange.setSalary(newSalary);
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
