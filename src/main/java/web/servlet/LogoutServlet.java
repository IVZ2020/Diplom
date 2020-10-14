package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/logoutServlet", name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getSession().setAttribute("currentUser", null);
        res.sendRedirect("/mainPage");
//        req.getServletContext().getRequestDispatcher("/mainPage.jsp").forward(req,res);
    }
}