package web.servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/deleteUser", name = "deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userForDeleteId = Integer.parseInt(req.getParameter("id"));
        userService.removeUserById(userForDeleteId);
        resp.sendRedirect("/getAllUsers");
    }
}
