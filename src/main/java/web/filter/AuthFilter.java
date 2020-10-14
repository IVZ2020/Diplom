package web.filter;

import entity.User;
import service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "AuthServlet")

public class AuthFilter extends HttpFilter {

    UserService userService = new UserService();

    @Override
    protected void doFilter (HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
    if (req.getSession().getAttribute("currentUser") == null) {
        chain.doFilter(req, resp);
    }
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        String message = "user " + currentUser.getLogin() + "already authorized";
        req.setAttribute("userAuthorizedMessage", message);
    req.getServletContext().getRequestDispatcher("/mainPage.jsp");
    }
}
