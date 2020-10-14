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

@WebServlet (urlPatterns = "/adminCabinet", name = "AdminCabinetServlet")
public class AdminCabinetServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentAdmin = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("currentAdmin", currentAdmin);
        List<String> userFieldList = userService.getUserFieldList (currentAdmin.getLogin());
        List<String> userFieldsValue = userService.getUserFieldsValue(currentAdmin.getLogin());
        req.getSession().setAttribute("adminFieldList", userFieldList);
        req.getSession().setAttribute("adminFieldsValue", userFieldsValue);
        req.getRequestDispatcher("/adminCabinet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
