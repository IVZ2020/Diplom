package service;

import dao.PostDao;
import entity.Post;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class PostService {

    PostDao postDao = new PostDao();

    public Date parseStringToDate (String dateString) {
        return postDao.parseStringToDate (dateString);
    }

    public String parseDateToString (Date date) {
        return postDao.parseDateToString(date);
    }

    public Date currentDate () {
        return postDao.currentDate();
    }

    public void addNewPost (Post post) {
        postDao.addNewPost(post);
    }

    public List<Post> createListOfPostByReceiverId (List<Post> userAllPostPageList, int receiverId, int currentUserId) {
        return postDao.createListOfPostByReceiverId( userAllPostPageList, receiverId, currentUserId);
    }

    public List<Post> getUserAllPostPageList(int currentUserId) {
        return postDao.getUserAllPostPageList(currentUserId);
    }
}
