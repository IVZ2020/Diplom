package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change/name", name = "ChangeUserNameServlet")
public class ChangeUserNameServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/name.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String oldName = (String) req.getParameter("oldName");
        String newName = req.getParameter("newName");
        String password = req.getParameter("password");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        int currentUserId = currentUser.getId();
        if (userService.changeUserName(newName, password, currentUserId)) {
            currentUser.setName(newName);
        }
        res.sendRedirect("/editAdminProfile");
    }
}