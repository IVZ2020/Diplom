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
        User user = (User) req.getSession().getAttribute("currentUser");
        double newSalary = Double.parseDouble(req.getParameter("newSalary"));
        String password = req.getParameter("password");
        int id = user.getId();
        if (userService.changeUserSalary(newSalary, password, id)) {
            user.setSalary(newSalary);
        }
        res.sendRedirect("/editAdminProfile");
    }
}
