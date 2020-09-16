package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/auth", name = "AuthServlet")
public class AuthServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginForCheck = req.getParameter("authLogin");
        String passForCheck = req.getParameter("authPassword");
        if (req.getParameter("selectAdmin") == "adminSelected") {
            if (userService.checkAdminLogin(loginForCheck)) {
                req.getSession().setAttribute("currentAdmin", userService.getAdminByLogin(loginForCheck));
            }
        } else {
            if (userService.checkUserLogin(loginForCheck)) {
                req.getSession().setAttribute("currentUser", userService.getUserByLogin(loginForCheck));
        }
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
        }
    }
}
