package web.filter;

import entity.User;

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
        if (req.getSession().getAttribute("currentUser") == null) {
            chain.doFilter(req, res);
//        } else if (req.getSession().getAttribute("currentUser") != null && ((User) (req.getSession().getAttribute("currentUser"))).getRole() == 2) {
//                req.getServletContext().getRequestDispatcher("/req.jsp").forward(req, res);
//            } else chain.doFilter(req, res);
        } else if (((User) (req.getSession().getAttribute("currentUser"))).getRole() == 1 || ((User) (req.getSession().getAttribute("currentUser"))).getRole() == 3) {
            req.getSession().removeAttribute("currentUser");
            req.getServletContext().getRequestDispatcher("/reg.jsp").forward(req, res);
        } else
            chain.doFilter(req, res);
    }
}