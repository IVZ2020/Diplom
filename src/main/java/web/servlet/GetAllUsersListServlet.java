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

@WebServlet (urlPatterns = "/getAllUsers", name = "GetAllUsersListServlet")
public class GetAllUsersListServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> allUsersList = userService.getAllUsers();
        req.getSession().setAttribute("allUsersList", allUsersList);
        req.getServletContext().getRequestDispatcher("/getAllUsersList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userIdForEditProfile = (int) req.getSession().getAttribute("userIdForEditProfile");
        req.getSession().setAttribute("id", userIdForEditProfile);
        User userByIdForEditProfile = userService.getUserById(userIdForEditProfile);
        req.getSession().setAttribute("userByIdForEditProfile", userByIdForEditProfile);
        req.getServletContext().getRequestDispatcher("/editUserProfile.jsp").forward(req, resp);

    }
}
