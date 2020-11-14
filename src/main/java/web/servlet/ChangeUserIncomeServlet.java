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
        double newIncome = Double.parseDouble(req.getParameter("newIncome"));
        User userForChange = (User) req.getSession().getAttribute("userForChange");
        int userForChangeId = userForChange.getId();
        if (userService.changeUserIncome(newIncome, userForChangeId)) {
            userForChange.setIncome(newIncome);
        }
        User currnetUser = (User) req.getSession().getAttribute("currentUser");
        if (userForChangeId == (currnetUser.getId()) && userForChange.getRole() == 2) {
            res.sendRedirect("/editAdminProfile");
        } else if (userForChange.getRole() == 1 && currnetUser.getRole() == 2) {
            res.sendRedirect("/getAllUsers");
        } else {
            res.sendRedirect("/editUserProfile");
        }
    }
}
