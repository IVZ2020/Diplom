package web.filter;

import dao.RegExDao;
import service.CalculatorService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.DoubleBinaryOperator;

@WebFilter (servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {

    CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.removeAttribute("result");
        req.removeAttribute("emptyDigits");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        if (req.getParameter("a") == null || req.getParameter("b") == null) {
            req.setAttribute("emptyDigits", "Введите значения в пустые поля");
            req.getServletContext().getRequestDispatcher("/calcs/calcAriphmethic.jsp").forward(req, res);
        }


        String operation = req.getParameter("operation");
        req.removeAttribute("result");
        if (!calculatorService.conditionsForCalculatorDivision(b) && operation.equals("div")) {
            req.setAttribute("denyDivision", "denyDivision");
            req.getServletContext().getRequestDispatcher("/calcs/calcAriphmethic.jsp").forward(req, res);
        } else if (calculatorService.conditionsForCalculator(a, b)) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("wrongDigit", "Введите корректные значения");
            req.getServletContext().getRequestDispatcher("/calcs/calcAriphmethic.jsp").forward(req, res);
        }
    }
}
