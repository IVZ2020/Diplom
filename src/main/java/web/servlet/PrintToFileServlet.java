package web.servlet;

import service.PrintService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/printToFile", name = "PrintTofileServlet")
public class PrintToFileServlet extends HttpServlet {

    PrintService printService = new PrintService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        req.getServletContext().getRequestDispatcher(requestURI).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringToPrint = req.getParameter("FileToPrint");
        printService.printStringService(stringToPrint);
        String requestURI = req.getRequestURI();
        req.getServletContext().getRequestDispatcher(requestURI).forward(req, resp);
    }
}
