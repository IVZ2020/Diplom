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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkLogin = req.getParameter("login");
        String checkPassword = req.getParameter("password");
        if (userService.isLoginExist(checkLogin)) {
            User user = userService.getUserByLogin(checkLogin);
            if (checkPassword.equals(user.getPass())) {
                req.getSession().setAttribute("currentUser", user);
                switch (user.getRole()) {

                    case 1:
                        resp.sendRedirect("/userCabinet");
                        break;
                    case 2:
                        resp.sendRedirect("/adminCabinet");
                        break;
                    case 3:
                        resp.sendRedirect("/moderatorCabinet");
                        break;
                }
            } else {
                req.setAttribute("message", "wrong pass");
                req.setAttribute("login", checkLogin);
                req.getRequestDispatcher("/auth.jsp").forward(req, resp);

            }
        } else {
            req.setAttribute("message", "user not found");
            req.getRequestDispatcher("/auth.jsp").forward(req, resp);
        }
    }
}