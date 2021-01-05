package web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RegServlet")
public class RegFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
            if ((req.getParameter("adminFlag") == "admin") && req.getSession().getAttribute("currentUser") != null) {
                req.getServletContext().getRequestDispatcher("/req.jsp").forward(req, res);
                //            res.sendRedirect("/reg");
            } else chain.doFilter(req, res);
        }
    }