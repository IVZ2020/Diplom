package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/reg", name = "RegServlet")
public class RegServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userLastName = req.getParameter("userLastName");
        String userLogin = req.getParameter("userLogin");
        String userPassword = req.getParameter("userPassword");
        userService.registerNewUser(new User(userName, userLastName, userLogin, userPassword, 1));
        req.setAttribute("userAdded", "Пользователь добавлен");
        req.getSession().setAttribute("currentUser", userService.getUserByLogin(userLogin));
        resp.sendRedirect("/userCabinet");
    }
}

