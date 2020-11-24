package web.servlet;

import dao.PostDao;
import entity.Post;
import entity.User;
import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/postServlet", name = "PostServlet")
public class PostServlet extends HttpServlet {

    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/post/userAllPostPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPost = (String) req.getParameter("newPost");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        int currentUserId = currentUser.getId();
        Post post = new Post(currentUserId,newPost);
        postService.addNewPost(post);
        resp.sendRedirect("/postServlet");

    }
}
