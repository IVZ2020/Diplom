package service;

import dao.PostDao;
import entity.Dialog;
import entity.Post;
import entity.User;

import java.awt.*;
import java.util.Date;
import java.util.HashSet;
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

    public Dialog createDialog(User currentUser, User receiver, List<Post> allPosts) {
        return postDao.createDialog(currentUser, receiver, allPosts);
    }


    public HashSet<User> getReceiverList(List<Post> userAllPostPageList) {
        return postDao.getReceiverList(userAllPostPageList);
    }
}
