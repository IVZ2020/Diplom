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

@WebServlet (urlPatterns = "/moneyEventServlet", name = "MoneyEventServlet")
public class MoneyEventServlet extends HttpServlet {

    MoneyService moneyService = new MoneyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().getServletContext().getRequestDispatcher("/money/moneyOperations.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        moneyService.addMoneyEvent(new MoneyEvent(Double.parseDouble(req.getParameter("currentMoneyEvent")),
                req.getParameter("cathegoryOfGoods"), currentUser.getId(), req.getParameter("typeOfMoneyEvent")));
        moneyService.updateUserBalanceById(currentUser.getId(), currentUser.getBalance());
        moneyService.updateUserDebtById(currentUser.getId(), currentUser.getDebt());
        resp.sendRedirect("/money/moneyEvent.jsp");
    }
}
