package web.servlet;

import entity.Menu;
import entity.User;
import service.MenuService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth", name = "AuthServlet")
public class AuthServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
    }
    MenuService menuService = new MenuService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String checkLogin = req.getParameter("login");
        String checkPassword = req.getParameter("password");
        if (userService.isLoginExist(checkLogin)) {
            User currentUser = userService.getUserByLogin(checkLogin);
            if (checkPassword.equals(currentUser.getPass())) {
                req.getSession().setAttribute("currentUser", currentUser);
                switch (currentUser.getRole()) {
                    case 1:
                        res.sendRedirect("/userCabinet");
                        break;
                    case 2:
                        res.sendRedirect("/adminCabinet");
                        break;
                    case 3:
                        res.sendRedirect("/moderatorCabinet");
                        break;
                }
            } else {
                req.setAttribute("message", "wrong pass");
                req.setAttribute("login", checkLogin);
                req.getRequestDispatcher("/auth.jsp").forward(req, res);

            }
        } else {
            req.setAttribute("message", "user not found");
            req.getRequestDispatcher("/auth.jsp").forward(req, res);
        }
    }
}