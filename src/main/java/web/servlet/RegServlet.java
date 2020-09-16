package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/reg", name = "RegServlet")
public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("SelectRole");
        switch (role) {
            case "admin": getServletContext().getRequestDispatcher("/regAdmin.jsp").forward(req, resp);;
            case "user": getServletContext().getRequestDispatcher("/regUser.jsp").forward(req, resp);;
            default: getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
        }
        resp.sendRedirect("/mainPage.jsp");

    }
}
