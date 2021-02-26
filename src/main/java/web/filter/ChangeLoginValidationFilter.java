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

@WebFilter (servletNames = "ChangeUserLoginServlet")
public class ChangeLoginValidationFilter  extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        if (req.getMethod().equals("POST")) {
            if (RegExDao.validationLogin(req.getParameter("newLogin"))) {
                chain.doFilter(req, res);
            } else {
                req.getSession().setAttribute("loginInvalidate", "Логин не валидный");
                res.sendRedirect("/change/login.jsp");
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}

