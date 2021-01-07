package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/changeUserBalanceServlet", name = "ChangeUserBalanceServlet")
public class ChangeUserBalanceServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/balance.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        double newBalance = Double.parseDouble(req.getParameter("newBalance"));
        User userForChange = (User) req.getSession().getAttribute("userForChange");
        int userForChangeId = userForChange.getId();
        if (userService.changeUserSalary(newBalance, userForChangeId)) {
            userForChange.setSalary(newBalance);
        }
        res.sendRedirect("/chooseServletAfterEditingProfile");

    }
}
