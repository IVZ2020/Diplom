package dao;

import entity.Dialog;
import entity.Post;
import entity.User;

import java.awt.*;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDao extends AbstractDao {

    private final static String ADD_POST = "INSERT INTO post VALUES (default, ?, ?, ?, ?, ?)";
    private final static String REMOVE_POST = "DELETE * FROM post p WHERE p.idpost = ?";
    private final static String GET_ALL_POSTS_BY_USER_ID = "SELECT * FROM post p WHERE p.iduser = ?";
    private final static String GET_LIST_OF_ID_SENDERS_BY_ID = "SELECT p.idsender FROM post p WHERE p.iduser = ? GROUP BY p.idsender";

    UserDao userdao = new UserDao();

//    private final static String GET_POSTS_TEST = "SELECT * FROM post p HAVING iduser = ?";

    public String parseDateToString (Date date) {
        return formatForDateNow.format(date);
    }

    public Date parseStringToDate (String dateString) {
        try {
            return formatForDateNow.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Date currentDate () {
        return new Date();
    }

    public void addNewPost(Post post) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_POST);
            preparedStatement.setInt(1,post.getIdDialog());
            preparedStatement.setInt(2, post.getIdUser());
            preparedStatement.setInt(3, post.getIdReceiver());
            preparedStatement.setString(4, post.getPost());
            preparedStatement.setString(5, parseDateToString(date));
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void removePost(Post post) {
//        try {
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_POST);
//            preparedStatement.setInt(1, post.getIdPost());
//            preparedStatement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public List<Post> getUserAllPostPageList (int userId) {
            List<Post> postList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSTS_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    Post post = new Post();
                    post.setIdPost(resultSet.getInt(1));
                    post.setIdDialog(resultSet.getInt(2));
                    post.setIdUser(resultSet.getInt(3));
                    post.setIdReceiver(resultSet.getInt(4));
                    post.setPost(resultSet.getString(5));
                    post.setStringDate(resultSet.getString(6));
                    postList.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    // Getting list of users who has diallog to current user
    public List<User> getReceiverList (List<Post> listOfPosts) {
        List<User> users = new ArrayList<>();
        for (Post post: listOfPosts) {
            int receiverId = post.getIdReceiver();
            User user = userdao.getUserById(receiverId);
            if (users.size() == 0) {
                users.add(user);
            }
                for (int i = users.size() - 1; i > 0; i--) {
                    if (users.get(i).equals(user)) {
                        users.add(user);
                    }
                }
        }
        return users;
    }

    public Dialog createDialog (User userSender, User userReceiver, List<Post> postList) {
            Dialog dialog = new Dialog();
            dialog.setUserSender(userSender);
            dialog.setUserReceiver(userReceiver);
            dialog.setPostList(postList);
            return dialog;
        }

    public List<Dialog> createListOfDialogs (Dialog dialog) {
        List<Dialog> listOfDialogs = new ArrayList<>();
        listOfDialogs.add(dialog);
        return listOfDialogs;
    }

    public List<Post> createListOfPostByReceiverId (List<Post> allPosts, int receiverId, int senderId) {
        List<Post> receiversPosts = new ArrayList<>();
        for (Post post:allPosts) {
            if (post.getIdReceiver() == receiverId) {
                receiversPosts.add(post);
            }
        }
        return receiversPosts;
    }

//    1 таблица
//    dialog: idIdalog, idReceiver, IdSender, Date
//
//    2 таблица
//    post: idMessage, idDialog, Post, idSender (тот, кто написал), Date
//
//    Логика:
//    Задача - знать id Диалога
//    Достать лист Post по idDialog
//
//    getInfoByIdDialog
//    из Таблицы 1 достает по idReceiver и idSender самих User


}