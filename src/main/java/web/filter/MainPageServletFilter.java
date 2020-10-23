package web.filter;

import entity.Menu;
import entity.User;
import service.MenuService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(servletNames = "MainPageServlet")
public class MainPageServletFilter extends HttpFilter {

    MenuService menuService = new MenuService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (currentUser == null) {
            req.setAttribute("mainMenu", menuService.getMainMenu());
            chain.doFilter(req, res);
        } else {
            String message = "user " + currentUser.getLogin() + " authorized";
            req.getSession().setAttribute("userAuthorizedMessage", message);
            req.getSession().setAttribute("mainMenuWithAuthItemsList", menuService.getMainMenuWithAuth());
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, res);
        }
    }
}