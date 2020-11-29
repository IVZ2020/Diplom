package web.servlet;

import dao.PostDao;
import entity.Post;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allUsersPostList", name = "AllUsersPostList")
public class ShowListOfUsersWithDialogsToCurrentUserServlet extends HttpServlet {

    PostDao postDao = new PostDao();
    User currentUser;
    int currentUserId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        currentUser = (User) req.getSession().getAttribute("currentUser");
        currentUserId = currentUser.getId();
        List<Post> userAllPostPageList = postDao.getUserAllPostPageList(currentUserId);
        req.getSession().setAttribute("userAllPostPageList", userAllPostPageList);
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
