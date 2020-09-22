package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth", name = "AuthServlet")
public class AuthServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
        req.getSession().setAttribute("currentMessage", userService.getMessage("auth"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginForCheck = req.getParameter("authLogin");
        req.getSession().setAttribute("currentLogin", loginForCheck);
        String passForCheck = req.getParameter("authPassword");

        if (!loginForCheck.equals(userService.checkLogin(loginForCheck))) {
            req.getSession().setAttribute("wrongLogin", userService.getMessage("Неверный логин"));
            getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
            } else if (!passForCheck.equals(userService.checkLogin(passForCheck))) {
                req.getSession().setAttribute("wrongPass", userService.getMessage("Неверный пароль"));
                getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
                } else {
                     req.getSession().setAttribute("currentUser", userService.getUserByLogin(loginForCheck));
                     getServletContext().getRequestDispatcher("/userCabinet.jsp").forward(req, resp);
                }
                getServletContext().getRequestDispatcher("/").forward(req, resp);
            }
        }
