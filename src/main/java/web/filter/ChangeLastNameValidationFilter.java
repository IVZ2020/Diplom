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

@WebFilter (servletNames = "ChangeUserLastNameServlet")
public class ChangeLastNameValidationFilter  extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            if (RegExDao.validationLogin(req.getParameter("newLastName"))) {
                chain.doFilter(req, res);
            } else {
                req.getSession().setAttribute("lastNameInvalidate", "Фамилия не валидная");
                res.sendRedirect("/change/lastName.jsp");
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}

