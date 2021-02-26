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

@WebFilter (servletNames = "ChangeUserPasswordServlet")
public class ChangePasswordValidationFilter  extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        if (req.getMethod().equals("POST")) {
            if (RegExDao.validationPassword(req.getParameter("newPassword"))) {
                req.getSession().removeAttribute("passwordInvalidate");
                chain.doFilter(req, res);
            } else {
                req.getSession().setAttribute("passwordInvalidate", "Пароль не валидный");
                res.sendRedirect("/change/password.jsp");
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}

