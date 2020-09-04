package dao;

import entity.User;

import java.sql.*;

public class UserStorage {

    Connection connection = null;
    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "learn2000_";
    User user = new User();

    private final static String ADD_USER = "insert into users u values (default, ?, ?, ?, ?, ?, ?, ?)";
    private final static String CHECK_LOGIN = "select * from users u where s.login = ?";
    private final static String REMOVE_BY_LOGIN = "delete * from users u where s.login = ?";

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
        return true;
            }

            public boolean checkUserByName (String name) {
        return true;
            }








}