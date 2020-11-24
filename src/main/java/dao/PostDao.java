package dao;

import entity.Post;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostDao extends AbstractDao {

    private final static String ADD_POST = "INSERT INTO post VALUES (default, ?, ?, ?, ?)";
    private final static String REMOVE_POST = "DELETE * FROM post p WHERE p.idpost = ?";


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
        String stringDate = parseDateToString(post.getDate());

        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_POST);
            preparedStatement.setInt(1,post.getIdDialog());
            preparedStatement.setInt(2, post.getIdUser());
            preparedStatement.setString(3, post.getPost());
            preparedStatement.setString(4, stringDate);
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
}
