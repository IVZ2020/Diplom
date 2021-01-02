package web.servlet;

import dao.PostDao;
import entity.Dialog;
import entity.Post;
import entity.User;
import service.PostService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (urlPatterns = "/correspondenceServlet", name = "CorrespondenceServlet")
public class CorrespondenceServlet extends HttpServlet {

    PostService postService = new PostService();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        int currentUserId = user.getId();
        int receiverId = Integer.parseInt(req.getParameter("receiverid"));
        List<Post> userAllPostPageList = postService.getUserAllPostPageList(currentUserId);
        List<Post> allPosts = postService.createListOfPostByReceiverId(userAllPostPageList, receiverId, currentUserId);
        Dialog dialog = postService.createDialog(user, userService.getUserById(receiverId), allPosts);
        req.setAttribute("userDialogsList", dialog);
        User receiver = userService.getUserById(receiverId);
        req.setAttribute("receiver", receiver);
        req.getServletContext().getRequestDispatcher("/post/userCorrespondence.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
