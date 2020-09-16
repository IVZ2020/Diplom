package web.servlet;
import entity.Menu;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import service.MenuService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Log4j
@WebServlet (urlPatterns = "/mainPage", name = "MainPageServlet")
public class MainPageServlet extends HttpServlet {

    MenuService menuService =  new MenuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Menu> menuItems = menuService.getMenuItems();
        req.setAttribute("menuItemsList", menuItems);
        log.info("menu");
        getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        }
    }