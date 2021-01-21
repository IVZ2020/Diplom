package web.servlet;

import entity.MoneyEvent;
import entity.User;
import service.MoneyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (urlPatterns = "/getAllUserMoneyEvent", name = "GetAllUserMoneyEvent")
public class GetAllUserMoneyEvents extends HttpServlet {

    MoneyService moneyService = new MoneyService();
    User user = new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("allMoneyEvents", (List<MoneyEvent>) moneyService.getAllUserMoneyEventById(currentUser.getId()));
        req.getServletContext().getRequestDispatcher("/money/moneyAccounting.jsp").forward(req, resp);
    }
}

