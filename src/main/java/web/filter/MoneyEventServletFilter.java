package web.filter;

import dao.OperationsDao;
import dao.RegExDao;
import entity.User;
import service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "MoneyEventServlet")
public class MoneyEventServletFilter extends HttpFilter {


    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String inputSumm = req.getParameter("currentMoneyEventSumm");
            if (!RegExDao.isDouble(inputSumm)) {
                req.setAttribute("wrongDigit", "Введите числовое значение");
                req.getServletContext().getRequestDispatcher("/money/moneyOperations.jsp").forward(req, res);
            }
            User currentUser = (User) (req.getSession().getAttribute("currentUser"));
            double currentMoneyEventSumm = Double.parseDouble(inputSumm);
            if (req.getParameter("typeOfMoneyEvent").equals("expenceEvent"))
                currentMoneyEventSumm = OperationsDao.changeSignOfDoubleNumber(currentMoneyEventSumm);
            currentUser.setBalance(currentUser.getBalance() + currentMoneyEventSumm);
            currentUser.setDebt(0);
            if (currentUser.getBalance() < 0) {
                currentUser.setDebt(OperationsDao.changeSignOfDoubleNumber(currentUser.getBalance()));
            }
            req.getSession().setAttribute("currentUser", currentUser);
            req.setAttribute("newBalance", currentUser.getBalance());
            req.setAttribute("newDebt", currentUser.getDebt());
            chain.doFilter(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }
}