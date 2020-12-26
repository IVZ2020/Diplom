package web.servlet;

import dao.PostDao;
import dao.UserDao;
import entity.Dialog;
import entity.Post;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/allUsersPostList", name = "AllUsersPostList")
public class ShowListOfUsersWithDialogsToCurrentUserServlet extends HttpServlet {

    UserService userService = new UserService();
    PostDao postDao = new PostDao();
    UserDao userDao = new UserDao();
    User currentUser;
    int currentUserId;
    List<Dialog> dialogs = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentUser = (User) req.getSession().getAttribute("currentUser");
        List<Post> userAllPostPageList = postDao.getUserAllPostPageList(currentUser.getId());
        User userSender = currentUser;
        List<User> listOfReceivers = userDao.getListOfReceivers(userAllPostPageList); // get Receiver from post
        for (User receiver : listOfReceivers) {
            //Choose only current receiver post for adding to Dialog
            List<Post> allPosts = postDao.createListOfPostByReceiverId(userAllPostPageList, receiver.getId(), currentUserId);
            Dialog dialog = postDao.createDialog(userSender, receiver, allPosts);
            dialog.setPostList(allPosts); //надо достать post только где совпадает receiver и sender

            dialogs.add(dialog); //Add Dialog to Dialog List to show in userAllPostPage.jsp
        }
        req.setAttribute("newListOfDialogs", dialogs);

        List<User> getListOfAllUsersWhoHasDialogWithCurrentUser = postDao.getReceiverList(userAllPostPageList);
        req.getSession().setAttribute("userAllPostPageList", userAllPostPageList);
        req.setAttribute("getListOfAllUsersWhoHasDialogWithCurrentUser", getListOfAllUsersWhoHasDialogWithCurrentUser);
        req.getServletContext().getRequestDispatcher("/post/userAllPostPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int conversationUserId = Integer.parseInt(req.getParameter("conversationUserId"));
        req.getSession().setAttribute("currentUserId", currentUserId);
        req.getSession().setAttribute("conversationUserId", conversationUserId);
        resp.sendRedirect("/postServlet");
    }
}
