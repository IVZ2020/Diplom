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
import java.util.List;

@WebServlet (urlPatterns = "/correspondenceServlet", name = "CorrespondenceServlet")
public class CorrespondenceServlet extends HttpServlet {

    PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        int currentUserId = user.getId();
        int receiverId = Integer.parseInt(req.getParameter("receiverid"));
        List<Post> userAllPostPageList = postService.getUserAllPostPageList(currentUserId);
        List<Post> allPosts = postService.createListOfPostByReceiverId(userAllPostPageList, receiverId, currentUserId);
        dialog
        req.setAttribute("");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
