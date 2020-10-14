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

@WebServlet (urlPatterns = "/moderatorCabinet", name = "ModeratorCabinetServlet")
public class ModeratorCabinetServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentModerator = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("currentModerator", currentModerator);
        List<String> userFieldList = userService.getUserFieldList (currentModerator.getLogin());
        List<String> userFieldsValue = userService.getUserFieldsValue(currentModerator.getLogin());
        req.getSession().setAttribute("moderatorFieldList", userFieldList);
        req.getSession().setAttribute("moderatorFieldsValue", userFieldsValue);
        req.getRequestDispatcher("/moderatorCabinet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
