package web.filter;

import entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "AuthServlet")

public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            chain.doFilter(req, resp);
        } else {
            resp.sendRedirect("/mainPage");
        }
    }
}
