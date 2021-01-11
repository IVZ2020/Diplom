package web.filter;

import dao.OperationsDao;
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
        if (req.getMethod().equals("Post")) {
            User currentUser = (User) (req.getSession().getAttribute("currentUser"));
            currentUser.setBalance(currentUser.getBalance() + Double.parseDouble(req.getParameter("currentMoneyEventSumm")));
            currentUser.setDebt(0);
            if (currentUser.getBalance() < 0) {
                currentUser.setDebt(OperationsDao.changeSignOfDoubleNumber(currentUser.getBalance()));
            }
            req.getSession().setAttribute("currentUser", currentUser);
            req.setAttribute("newBalance", currentUser.getBalance());
            req.setAttribute("newDebt", currentUser.getDebt());
        } else {
            chain.doFilter(req, res);
        }
}
}
