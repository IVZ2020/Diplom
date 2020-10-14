package dao;

import entity.Menu;
import entity.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import service.Writer;

import java.lang.reflect.Field;
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
    private final static String IS_LOGIN_EXIST = "select * from users u where u.login = ?";
    private final static String REMOVE_BY_LOGIN = "delete * from users u where u.login = ?";
    private final static String CHECK_BY_NAME = "select * from users u where u.name = ?";
    private final static String GET_USER_BY_LOGIN = "select * from users u where u.login = ?";
    private final static String REG_USER = "insert into users values (default, ?, ?, ?, ?, ?)";
    private final static String GET_MESSAGE = "select * from messages m where m.messagerus = ?";

    ;

    public void regNewUser(User user) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(REG_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPass());
            preparedStatement.setInt(5, user.getRole());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String name, String lastName, String login, String pass, int role, double balance, double salary, double income) {
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

    public boolean removeUserByLogin(String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLoginExistInBase(String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(IS_LOGIN_EXIST);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkUserByName(String name) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.close();
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByLogin(String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User(
                    (resultSet.getInt(1)),
                    (resultSet.getString(2)),
                    (resultSet.getString(3)),
                    (resultSet.getString(4)),
                    (resultSet.getString(5)),
                    (resultSet.getInt(6)),
                    (resultSet.getDouble(7)),
                    (resultSet.getDouble(8)),
                    (resultSet.getDouble(9)));
            connection.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMessage(String message) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MESSAGE);
            preparedStatement.setString(1, message);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User();
            connection.close();
            return resultSet.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean ifUserHasFieldsNull(String login) {
        User ifUserHasFieldsNull = getUserByLogin(login);
        Field[] fields = ifUserHasFieldsNull.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();

            if (field == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameOrLastNameEmpty(String login) {
        User user = getUserByLogin(login);
        if (user.getName().isEmpty() || (user.getLastName().isEmpty())) return true;
        return false;
    }

    public List<User> getAllUsers() {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getUserFieldList (String login) {
        User user = getUserByLogin(login);
        Field[] fields = user.getClass().getDeclaredFields();
        List<String> usersFieldList = new ArrayList<>();
        for (Field field: fields) {
            String fieldName = field.getName();
            usersFieldList.add(fieldName);
        }
        return usersFieldList;
    }

    public List<String> findNullFieldsInUser (String login) {
        List<String> list = new ArrayList<>();
        User user = getUserByLogin(login);
        Field[] fields = User.class.getDeclaredFields();
        for (Field field: fields) {
            Object o = null;
            try {
                field.setAccessible(true);
                o = field.get(user);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (o == null) {
                list.add(field.getName() + " field is empty");
            }
        }
        return list;
    }

    public List<String> findNullFieldsInUser_ (String login) {
        User user = getUserByLogin(login);
        Field[] fields = user.getClass().getDeclaredFields();
        List<String> fieldsWithNull = new ArrayList<>();
        for (Field f : User.class.getDeclaredFields()) {
            if (f == null) {
                fieldsWithNull.add(f.getName());
            }
            return fieldsWithNull;
        }
        return null;
    }


    public List<String> getUserFieldsValue (String userLogin) {
        User user = getUserByLogin(userLogin);
        List<String> userFieldsValue = new ArrayList<>();
        userFieldsValue.add(String.valueOf(user.getId()));
        userFieldsValue.add(user.getName());
        userFieldsValue.add(user.getLastName());
        userFieldsValue.add(user.getLogin());
        userFieldsValue.add(user.getPass());
        userFieldsValue.add(String.valueOf(user.getRole()));
        userFieldsValue.add(String.valueOf(user.getBalance()));
        userFieldsValue.add(String.valueOf(user.getSalary()));
        userFieldsValue.add(String.valueOf(user.getIncome()));
        return userFieldsValue;
    }
}
