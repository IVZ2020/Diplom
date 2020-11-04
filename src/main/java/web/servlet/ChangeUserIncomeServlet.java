package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/change/income", name = "ChangeUserIncomeServlet")
public class ChangeUserIncomeServlet extends HttpServlet {

    UserService userService =  new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/income.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        double newIncome = Double.parseDouble(req.getParameter("newIncome"));
        String password = req.getParameter("password");
        if (userService.changeUserIncome(newIncome, password, user.getId())) {
            user.setIncome(newIncome);
        }
        res.sendRedirect("/editUserProfile");
    }
}
