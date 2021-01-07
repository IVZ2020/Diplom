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

@WebServlet (urlPatterns = "/editUserProfile", name="EditUserProfileServlet")
public class EditUserProfileServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<String> userFieldLinks = userService.getUserFieldLinksForEditProfile("userTable");
        List<String> userFieldRusNames = userService.getUserFieldRusNamesForEditProfile("userTable");
        req.getSession().setAttribute("userFieldLinks", userFieldLinks);
        req.getSession().setAttribute("userFieldRusNames", userFieldRusNames);
        if (req.getParameter("useridforchange") != null) {
            int userIdForChange = Integer.parseInt(req.getParameter("useridforchange"));
            User user = userService.getUserById(userIdForChange);
            req.getSession().setAttribute("userForChange", user);
        }
        req.getServletContext().getRequestDispatcher("/editUserProfile.jsp").forward(req,res);
        }
//        req.setAttribute("userForEditProfile", user);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/editUserProfile");
    }
}
