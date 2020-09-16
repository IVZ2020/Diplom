package dao;

import entity.Menu;
import entity.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import service.Writer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class UserDao {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection connection = null;
    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "learn2000_";

    private final static String ADD_USER = "insert into users u values (default, ?, ?, ?, ?, ?, ?, ?)";
    private final static String CHECK_USER_LOGIN = "select * from users u where u.login = ?";
    private final static String CHECK_ADMIN_LOGIN = "select * from admins a where a.login = ?";
    private final static String REMOVE_BY_LOGIN = "delete * from users u where u.login = ?";
    private final static String CHECK_BY_PASS = "select * from users u where u.pass = ?";
    private final static String CHECK_BY_NAME = "select * from users u where u.name = ?";
    private final static String GET_USER_BY_LOGIN = "select * from users u where u.login = ?";
    private final static String GET_ADMIN_BY_LOGIN = "select * from admins a where a.login = ?";
    private final static String REG_USER = "insert into users values (default, ?, ?, ?, ?)";
    private final static String REG_ADMIN = "insert into admins values (default, ?, ?, ?, ?)";

    public void regNewUser (User user) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(REG_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void regNewAdmin (User user) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(REG_ADMIN);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser (String name, String lastName, String login, String pass, int role, double balance, double salary, double income) {
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
            preparedStatement.execute();
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
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_LOGIN);
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
            }

    public boolean checkAdminByLogin (String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES,PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ADMIN_LOGIN);
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
            User user = new User(
                            resultSet.getInt(1),
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

    public User getAdminByLogin (String login) {

        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADMIN_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            User admin = new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6));
            return admin;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}