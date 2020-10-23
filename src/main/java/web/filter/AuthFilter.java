package web.filter;

import entity.Menu;
import entity.User;
import service.MenuService;
import service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(servletNames = "AuthServlet")

public class AuthFilter extends HttpFilter {

    UserService userService = new UserService();
    MenuService  menuService = new MenuService();

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
