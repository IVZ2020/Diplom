package dao;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    Connection connection = null;
    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "learn2000_";
    User user = new User();

    private final static String ADD_USER = "insert into users u values (default, ?, ?, ?, ?, ?, ?, ?)";
    private final static String CHECK_LOGIN = "select * from users u where s.login = ?";
    private final static String REMOVE_BY_LOGIN = "delete * from users u where s.login = ?";
    private final static String CHECK_BY_PASS = "select * from users u where u.pass = ?";
    private final static String CHECK_BY_NAME = "select * from users u where u.name = ?";
    private final static String GET_USER_BY_LOGIN = "select * from users u s.login = ?";

    public void addUser (String name, String lastName, String login, String pass, int  role, double balance, double salary, double income) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, pass);
            preparedStatement.setInt(5, role);
            preparedStatement.setDouble(6, balance);
            preparedStatement.setDouble(7, salary);
            preparedStatement.setDouble(8, income);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public boolean removeUserByLogin (String login) {
            try {
                connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
                PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_BY_LOGIN);
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public boolean checkUserByLogin (String login) {
            try {
                connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES,PASS_TABLES);
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN);
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
            }

        public boolean checkUserPassword (String pass) {
            try {
                connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES,PASS_TABLES);
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_PASS);
                preparedStatement.setString(1, pass);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
            }

        public boolean checkUserByName (String name) {
            try {
                connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES,PASS_TABLES);
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_NAME);
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

    public User getUserByLogin (String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = new User(resultSet.getLong(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getDouble(7),
                            resultSet.getDouble(8),
                            resultSet.getDouble(9));
            return user;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}