package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/changeUserRoleServlet", name = "ChangeUserRoleServlet")
public class ChangeUserRoleServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/change/role.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userForChange = (User) req.getSession().getAttribute("userForChange");
        int userForChangeId = userForChange.getId();
        int newUserRole = Integer.parseInt( req.getParameter("newUserRole"));
        if (userService.changeUserRole(newUserRole, userForChangeId)) {
            userForChange.setRole(newUserRole);
        }
        resp.sendRedirect("/chooseServletAfterEditingProfile");
    }
}
