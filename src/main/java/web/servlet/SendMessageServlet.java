package web.servlet;

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

@WebServlet(urlPatterns = "/sendMessageServlet", name = "SendMessageServlet")
public class SendMessageServlet extends HttpServlet {

    PostService postService = new PostService();
    UserService userService = new UserService();
    User currentUser = new User();
    Post post = new Post();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idReceiver = Integer.parseInt(req.getParameter("receiverid"));
        User receiver = userService.getUserById(idReceiver);
        String receiverLogin = receiver.getLogin();
        req.setAttribute("receiver", receiver);
        req.setAttribute("receiverLogin", receiverLogin);
        req.getServletContext().getRequestDispatcher("/post/sendMessage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPost = req.getParameter("newPost");
        currentUser = (User) req.getSession().getAttribute("currentUser");
        int idReceiver = Integer.parseInt(req.getParameter("receiverid"));
        post = new Post(currentUser.getId(), idReceiver, newPost);
        postService.addNewPost(post);
        resp.sendRedirect("/allUsersPostList");

    }
}
