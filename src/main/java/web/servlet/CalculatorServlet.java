package web.servlet;

import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/calcServlet", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("result").isEmpty()) {
            req.setAttribute("calcResult", req.getParameter("result"));
        } else {
            req.getServletContext().getRequestDispatcher("/calcs/calcAriphmethic.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        req.getSession().setAttribute("result", calculatorService.calculatorSimple(a, b, operation));
        resp.sendRedirect("/calcServlet");
    }
}
