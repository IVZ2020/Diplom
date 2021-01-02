package web.servlet;

import dao.PostDao;
import dao.UserDao;
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
import java.util.HashSet;
import java.util.List;

@WebServlet(urlPatterns = "/allUsersPostList", name = "AllUsersPostList")
public class ShowListOfUsersWithDialogsToCurrentUserServlet extends HttpServlet {

    UserService userService = new UserService();
    PostService postService = new PostService();
    PostDao postDao = new PostDao();
    UserDao userDao = new UserDao();
    User currentUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dialog> dialogs = new ArrayList<>();
        currentUser = (User) req.getSession().getAttribute("currentUser");
        int currentUserId = currentUser.getId();
        //removing duplicates in list of receivers
        List<Post> userAllPostPageList = postDao.getUserAllPostPageList(currentUserId);
        HashSet<User> receiverList = postDao.getReceiverList(userAllPostPageList);
        for (User receiver : receiverList) {
            //Choose only current receiver post for adding to Dialog
            List<Post> allPosts = postService.createListOfPostByReceiverId(userAllPostPageList, receiver.getId(), currentUserId);
            Dialog dialog = postService.createDialog(currentUser, receiver, allPosts);
            dialogs.add(dialog); //Add Dialog to Dialog List to show in userAllPostPage.jsp
        }
        req.setAttribute("newListOfDialogs", dialogs);
        HashSet<User> allUserList = userService.getAllUsersHashList();
        req.setAttribute("getAllUsersHashList", allUserList);
        req.getServletContext().getRequestDispatcher("/post/userAllPostPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int conversationUserId = Integer.parseInt(req.getParameter("conversationUserId"));
        int currentUserId = currentUser.getId();
        req.getSession().setAttribute("currentUserId", currentUserId);
        req.getSession().setAttribute("conversationUserId", conversationUserId);
        resp.sendRedirect("/postServlet");
    }
}