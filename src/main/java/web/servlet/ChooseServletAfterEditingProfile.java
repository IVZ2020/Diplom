package web.servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/chooseServletAfterEditingProfile", name = "ChooseServletAfterEditingProfile")
public class ChooseServletAfterEditingProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userForChange = (User) req.getSession().getAttribute("userForChange");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        int userForChangeId = userForChange.getId();
        if (userForChangeId == (currentUser.getId()) && userForChange.getRole() == 2) {
            resp.sendRedirect("/editAdminProfile");
        }
        else {
            resp.sendRedirect("/editUserProfile");
        }
    }
}