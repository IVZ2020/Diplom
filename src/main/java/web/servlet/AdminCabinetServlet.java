package web.servlet;

import entity.MenuItem;
import entity.User;
import service.FieldsService;
import service.MenuService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/adminCabinet", name = "AdminCabinetServlet")
public class AdminCabinetServlet extends HttpServlet {

    UserService userService = new UserService();
    MenuService menuService = new MenuService();
    FieldsService fieldsService = new FieldsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        List<String> userFieldList = userService.getUserFieldList(currentUser.getLogin());
        List<String> userFieldsValue = userService.getUserFieldsValue(currentUser.getLogin());
        req.getSession().setAttribute("adminFieldList", userFieldList);
        req.getSession().setAttribute("adminFieldsValue", userFieldsValue);
        List<MenuItem> adminMenu = menuService.getAdminMenu();
        req.getSession().setAttribute("adminMenu", adminMenu);
        req.getServletContext().getRequestDispatcher("/adminCabinet.jsp").forward(req, resp);
    }

    }

