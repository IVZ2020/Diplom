package web.servlet;

import entity.Post;
import entity.User;
import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/dialogPage", name = "DialogPageServlet")
public class DialogPageServlet extends HttpServlet {

    PostService postService = new PostService();
    User currentUser = new User();
    Post post = new Post();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/post/dialogPage.jsp").forward(req, resp);
    }
}
