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

@WebFilter (servletNames = "ChangeUserNameServlet")
public class ChangeNameValidationFilter  extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            if (RegExDao.validationName(req.getParameter("newName"))) {
                chain.doFilter(req, res);
            } else {
                req.getSession().setAttribute("nameInvalidate", "Имя не валидное");
                res.sendRedirect("/change/name.jsp");
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}

