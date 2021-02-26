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
import java.util.Arrays;
import java.util.List;

@WebFilter(servletNames = "RegServlet")
public class RegUserValidationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        if (req.getMethod().equals("POST")) {
            String userName = req.getParameter("userName");
            String userLastName = req.getParameter("userLastName");
            String userLogin = req.getParameter("userLogin");
            String userPassword = req.getParameter("userPassword");

            req.getSession().removeAttribute("nameInvalid");
            req.getSession().removeAttribute("lastNameInvalid");
            req.getSession().removeAttribute("loginInvalid");
            req.getSession().removeAttribute("passwordInvalid");

            if (!RegExDao.validationName(userName)) {
                req.getSession().setAttribute("nameInvalid", "Введите корректное имя");
                res.sendRedirect("/reg.jsp");
            } else
            if (!RegExDao.validationLastName(userLastName)) {
                req.getSession().setAttribute("lastNameInvalid", "Введите корректную фамилию");
                res.sendRedirect("/reg.jsp");
            } else
            if (!RegExDao.validationLogin(userLogin)) {
                req.getSession().setAttribute("loginInvalid", "Введите корректный логин");
                res.sendRedirect("/reg.jsp");
            } else
            if (!RegExDao.validationPassword(userPassword)) {
                req.getSession().setAttribute("passwordInvalid", "Введите корректный пароль");
                res.sendRedirect("/reg.jsp");
            } else {
                chain.doFilter(req,res);
            }
        }
        else chain.doFilter(req, res);
    }
}
