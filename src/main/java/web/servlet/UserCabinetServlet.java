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
        List<String> userFieldList = userService.getUserFieldList (currentUser.getLogin());
        List<String> userFieldsValue = userService.getUserFieldsValue(currentUser.getLogin());
        req.getSession().setAttribute("userFieldList", userFieldList);
        req.getSession().setAttribute("userFieldsValue", userFieldsValue);
        req.getRequestDispatcher("/userCabinet.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
