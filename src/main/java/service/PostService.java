package service;

import dao.PostDao;
import entity.Post;

import java.util.Date;

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
}
