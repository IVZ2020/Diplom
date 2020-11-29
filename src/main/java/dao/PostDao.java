package dao;

import entity.Post;

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
            preparedStatement.setInt(3, post.getIdSender());
            preparedStatement.setString(4, post.getPost());
            preparedStatement.setString(5, parseDateToString(date));
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePost(Post post) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_POST);
            preparedStatement.setInt(1, post.getIdPost());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Post> getUserAllPostPageList (int userId) {
            List<Post> postList = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSTS_BY_USER_ID); //GET_ALL_POSTS_BY_USER_ID
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                    Post post = new Post();
                    post.setIdPost(resultSet.getInt(1));
                    post.setIdDialog(resultSet.getInt(2));
                    post.setIdUser(resultSet.getInt(3));
                    post.setIdSender(resultSet.getInt(4));
                    post.setPost(resultSet.getString(5));
                    post.setStringDate(resultSet.getString(6));
                    postList.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }
}