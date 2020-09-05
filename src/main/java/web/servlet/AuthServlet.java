package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (urlPatterns = "/auth", name = "AuthServlet")
public class AuthServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/webapp/auth.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginForCheck = req.getParameter("login");
        String passForCheck = req.getParameter("pass");
        if (userService.authUser(loginForCheck, passForCheck)) {
            User userChecked = userService.getUserByLogin(loginForCheck);
            req.getSession().setAttribute("userChecked", userChecked);
            resp.sendRedirect("/mainPage.jsp");
        } else {
            resp.sendRedirect("/auth.jsp");
        }
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
        }
    }

