package web.servlet;

import entity.User;
import service.StringUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name = "RegServlet")
public class RegServlet extends HttpServlet {

    UserService userService = new UserService();
    StringUtils stringUtils = new StringUtils();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userLastName = req.getParameter("userLastName");
        String userLogin = req.getParameter("userLogin");
        String userPassword = req.getParameter("userPassword");
        if (userService.isLoginExist(userLogin)) {
            req.setAttribute("userExist", "User " + userLogin + " alreadyExist. Try another login");
            req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, res);
        } else {
            userService.registerNewUser(new User(userName, userLastName, userLogin, userPassword, 1));
            req.setAttribute("userAdded", "Пользователь " + userLogin + " добавлен");
            req.getSession().removeAttribute("currentUser");
            req.getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, res);
            }
        }
    }

