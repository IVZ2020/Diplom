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

@WebServlet (urlPatterns = "/userCabinet", name = "UserCabinetServlet")
public class UserCabinetServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currentUser = (User) req.getSession().getAttribute("currentUser");
        if (userService.ifUserHasFieldsNull(currentUser.getLogin())) {
            List<String> userFieldsNullList = userService.getUserFieldsNullList(currentUser.getLogin());
            req.setAttribute("emptyFieldsList", userFieldsNullList);
            getServletContext().getRequestDispatcher("/userCabinet.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/userCabinet.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
