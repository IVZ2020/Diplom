package web.filter;

import dao.OperationsDao;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (servletNames = "MoneyEventServlet")
public class MoneyTypeOfEventFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("Post")) {
            if (req.getParameter("moneyEventType").equals("expenceEvent")) {
                Double currentMoneyEventSumm = OperationsDao.changeSignOfDoubleNumber
                        (Double.parseDouble(req.getParameter("currentMoneyEventSumm")));
                        req.setAttribute("currentMoneyEventSumm", currentMoneyEventSumm);
                        chain.doFilter(req,res );
            }
        }
        chain.doFilter(req,res );
    }
}
