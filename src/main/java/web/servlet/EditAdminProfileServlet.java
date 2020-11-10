package web.servlet;

import entity.Fields;
import entity.User;
import service.FieldsService;
import service.StringUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/editAdminProfile", name = "EditAdminProfileServlet")
public class EditAdminProfileServlet extends HttpServlet {

    UserService userService = new UserService();
    FieldsService fieldsService = new FieldsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("userForChange", currentUser);
        List<String> userFieldLinks = userService.getUserFieldLinksForEditProfile("adminTable");
        List<String> userFieldRusNames = userService.getUserFieldRusNamesForEditProfile("adminTable");
        req.getSession().setAttribute("adminFieldLinks", userFieldLinks);
        req.getSession().setAttribute("adminFieldRusNames", userFieldRusNames);
        req.getServletContext().getRequestDispatcher("/editAdminProfile.jsp").forward(req,res);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fieldToChange = req.getParameter("fieldToChange");
        StringUtils stringUtils = new StringUtils();
        User userForChange = (User) req.getSession().getAttribute("currentUser");
        req.getSession().setAttribute("userForChange", userForChange);
        String urlForRedirect = "/change/" + stringUtils.firstUpperCase(fieldToChange);
        req.getServletContext().getRequestDispatcher(urlForRedirect + ".jsp");
        }
    }