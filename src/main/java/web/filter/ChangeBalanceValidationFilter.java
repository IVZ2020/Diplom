package web.filter;

import dao.RegExDao;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter (servletNames = "ChangeUserIncomeServlet")
public class ChangeBalanceValidationFilter  extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            if (RegExDao.isDouble(req.getParameter("newIncome"))) {
                chain.doFilter(req, res);
            } else {
                req.getSession().setAttribute("doubleInvalidate", "Введите число");
                res.sendRedirect("/change/balance.jsp");
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}

