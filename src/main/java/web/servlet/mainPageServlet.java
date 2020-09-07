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

@WebServlet (urlPatterns = "/webapp/mainPage.jsp", name = "mainPageServlet")
public class mainPageServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/webapp/mainPage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] menuList2 = new String[] {"auth", "signup", "exit"};
        req.setAttribute("menuList2", menuList2);
        String loginForCheck = req.getParameter("login");
        String passForCheck = req.getParameter("pass");
        if (userService.authUser(loginForCheck, passForCheck)) {
            User userChecked = userService.getUserByLogin(loginForCheck);
            req.getSession().setAttribute("userChecked", userChecked);
            resp.sendRedirect("/webapp/mainPage.jsp");
        } else {
            resp.sendRedirect("/webapp/mainPage.jsp");
        }
            getServletContext().getRequestDispatcher("/webapp/mainPage.jsp").forward(req, resp);
        }
    }

