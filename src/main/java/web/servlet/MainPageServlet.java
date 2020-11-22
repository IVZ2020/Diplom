package web.servlet;

import lombok.extern.log4j.Log4j;
import service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@WebServlet(urlPatterns = "/mainPage", name = "MainPageServlet")
public class MainPageServlet extends HttpServlet {

    MenuService menuService = new MenuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req, resp);
    }

//        log.info("menu");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}