package dao;

import entity.Fields;
import entity.Post;
import entity.User;
import lombok.extern.log4j.Log4j;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j
public class UserDao extends AbstractDao {
    private final static String ADD_USER = "INSERT INTO users u VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
    private final static String REG_USER = "INSERT INTO users VALUES (DEFAULT, ?, ?, ?, ?, ?)";
    private final static String IS_LOGIN_EXIST = "SELECT login FROM users u WHERE u.login = ?";
    private final static String REMOVE_BY_LOGIN = "DELETE * FROM users u WHERE u.login = ?";
    private final static String GET_USER_BY_ID = "SELECT * FROM users u WHERE u.id = ?";
    private final static String CHECK_BY_NAME = "SELECT * FROM users u WHERE u.name = ?";
    private final static String GET_USER_BY_LOGIN = "SELECT * FROM users u WHERE u.login = ?";
    private final static String GET_USER_BY_NAME = "SELECT * FROM users u WHERE u.name = ?";
    private final static String DELETE_USER_BY_ID = "DELETE FROM users u WHERE u.id = ?";
    private final static String GET_USERS_BY_ID_LIST = "SELECT * FROM users u WHERE u.id = ?";



    private final static String GET_ALL_USERS = "SELECT * FROM USERS";
    private final static String GET_MESSAGE = "SELECT * FROM messages m WHERE m.messagerus = ?";

    private final static String GET_ADMIN_FIELD_LINKS = "SELECT fieldlink FROM adminfields";
    private final static String GET_USER_FIELD_LINKS = "SELECT fieldlink FROM userfields";
    private final static String GET_ADMIN_FIELD_RUS_NAMES = "SELECT fieldrus FROM adminfields";
    private final static String GET_USER_FIELD_RUS_NAMES = "SELECT fieldrus FROM userfields";

    private final static String UPDATE_BALANCE_BY_ID = "UPDATE users SET salary = ? WHERE id = ?";
    private final static String UPDATE_INCOME_BY_ID = "UPDATE users SET income = ? WHERE id = ?";
    private final static String UPDATE_NAME_BY_ID = "UPDATE users SET name = ? WHERE id = ?";
    private final static String UPDATE_LASTNAME_BY_ID = "UPDATE users SET lastname = ? WHERE id = ?";
    private final static String UPDATE_PASSWORD_BY_ID = "UPDATE users SET pass = ? WHERE id = ?";
    private final static String UPDATE_LOGIN_BY_ID = "UPDATE users SET login = ? WHERE id = ?";
    private final static String UPDATE_ROLE_BY_ID = "UPDATE users SET role = ? WHERE id = ?";


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

    public boolean removeUserByLogin(String login) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
//            connection.close();
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
//            connection.close();
            if (resultSet.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isUserNameExistsInBase(String name) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
//            connection.close();
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
            return new User(
                    (resultSet.getInt(1)),
                    (resultSet.getString(2)),
                    (resultSet.getString(3)),
                    (resultSet.getString(4)),
                    (resultSet.getString(5)),
                    (resultSet.getInt(6)),
                    (resultSet.getDouble(7)),
                    (resultSet.getDouble(8)));
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(int id) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setInt(1, id);
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
                    (resultSet.getDouble(8)));
            connection.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User getUserByName(String name) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(
                    (resultSet.getInt(1)),
                    (resultSet.getString(2)),
                    (resultSet.getString(3)),
                    (resultSet.getString(4)),
                    (resultSet.getString(5)),
                    (resultSet.getInt(6)),
                    (resultSet.getDouble(7)),
                    (resultSet.getDouble(8)));
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers () {
        List<User> allUsersList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User (
                        (resultSet.getInt(1)),
                        (resultSet.getString(2)),
                        (resultSet.getString(3)),
                        (resultSet.getString(4)),
                        (resultSet.getString(5)),
                        (resultSet.getInt(6)),
                        (resultSet.getDouble(7)),
                        (resultSet.getDouble(8)));
                allUsersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsersList;
    }



    public String getMessage(String message) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MESSAGE);
            preparedStatement.setString(1, message);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User();
//            connection.close();
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

    public List<String> getUserFieldList(String login) {
        User user = getUserByLogin(login);
        Field[] fields = user.getClass().getDeclaredFields();
        List<String> usersFieldList = new ArrayList<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            usersFieldList.add(fieldName);
        }
        return usersFieldList;
    }

    public List<String> getUserFieldsValue(String userLogin) {
        User user = getUserByLogin(userLogin);
        List<String> userFieldsValue = new ArrayList<>();
        userFieldsValue.add(String.valueOf(user.getId()));
        userFieldsValue.add(user.getName());
        userFieldsValue.add(user.getLastName());
        userFieldsValue.add(user.getLogin());
        userFieldsValue.add(user.getPass());
        userFieldsValue.add(String.valueOf(user.getRole()));
        userFieldsValue.add(String.valueOf(user.getBalance()));
        return userFieldsValue;
    }

    public boolean changeUserLastName(String newName, int id) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LASTNAME_BY_ID);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
//                preparedStatement.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public List<String> getUserProfileFieldList(String login) {
//        User user = getUserByLogin(login);
//        User userForProfile = new User();
//        userForProfile.setName(user.getName());
//        userForProfile.setLastName(user.getLastName());
//        userForProfile.setLogin(user.getLogin());
//        userForProfile.setPass(user.getPass());
//        userForProfile.setSalary(user.getSalary());
//        userForProfile.setIncome(user.getIncome());
//        Field[] fields = userForProfile.getClass().getDeclaredFields();
//        List<String> userProfileFieldList = new ArrayList<>();
//        for (Field field : fields) {
//            String fieldName = field.getName();
//            userProfileFieldList.add(fieldName);
//        }
//        return userProfileFieldList;
//    }

    public List<String> getUserProfileFieldsValues(String userLogin) {
        User user = getUserByLogin(userLogin);
        List<String> userProfileFieldsValue = new ArrayList<>();
        userProfileFieldsValue.add(user.getName());
        userProfileFieldsValue.add(user.getLastName());
        userProfileFieldsValue.add(user.getLogin());
        userProfileFieldsValue.add(user.getPass());
        return userProfileFieldsValue;
    }

//    public List<Fields> fieldsForEditAdminProfile (String login) {
//        User user = getUserByLogin(login);
//        List<Fields> fieldsForEditAdminProfile = new ArrayList<>();
//        return null;
//    }


    public void checkInputLoginRegEx(String login) {
        Pattern p1 = Pattern.compile("a");
        Matcher m1 = p1.matcher(login);
    }

    public boolean changeUserName(String newName, int id) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NAME_BY_ID);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<String> getUserFieldLinksForEditProfile (String tableName) {
        List<String> links = new ArrayList<>();
        switch (tableName) {
            case ("adminTable") :
                try {
                    connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
                    PreparedStatement preparedStatement = connection.prepareStatement(GET_ADMIN_FIELD_LINKS);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        links.add(resultSet.getString(1));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case ("userTable") :
                try {
                    connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
                    PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_FIELD_LINKS);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        links.add(resultSet.getString(1));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                break;
        }
        return links;
    }

    public List<String> getUserFieldRusNamesForEditProfile (String tableName) {
        List<String> rusNames = new ArrayList<>();
        switch (tableName) {
            case ("adminTable") :
                try {
                    connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
                    PreparedStatement preparedStatement = connection.prepareStatement(GET_ADMIN_FIELD_RUS_NAMES);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        rusNames.add(resultSet.getString(1));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case ("userTable") :
                try {
                    connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
                    PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_FIELD_RUS_NAMES);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        rusNames.add(resultSet.getString(1));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            default:
                break;
        }
        return rusNames;
    }

    public boolean changeUserPassword(String newPassword, int currentUserId) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_BY_ID);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, currentUserId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeUserSalary(double newSalary, int currentUserId) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BALANCE_BY_ID);
            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, currentUserId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeUserIncome (double newIncome, int currentUserId) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INCOME_BY_ID);
            preparedStatement.setDouble(1, newIncome);
            preparedStatement.setInt(2,currentUserId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void removeUserById(int userForDeleteId) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1,userForDeleteId);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean changeUserLogin(String newLogin, int currentUserId) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LOGIN_BY_ID);
            preparedStatement.setString(1, newLogin);
            preparedStatement.setInt(2, currentUserId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getListOfUsersById(List<Integer> sendersIdList) {
        List<User> userList = new ArrayList<>();
        User user;
                for (int i = sendersIdList.size() - 1; i >= 0; i--) {
                    user = getUserById(sendersIdList.get(i));
                userList.add(user);
        }
        return userList;
    }

    public List<User> getListOfReceivers (List<Post> postList) {
        List<User> receiversList = new ArrayList<>();
        if (postList.size() != 0) {
            for (Post post : postList) {
                if (post != null) {
                    receiversList.add(getUserById(post.getIdReceiver()));
                }
            }
        }
        return receiversList;
    }



    public User getReceiverFromPostList (List<Post> postList) {
        User receiver = new User();

        if (postList.size() != 0) {
            for (Post post : postList) {
                if (post != null) {
                    receiver = getUserById(post.getIdReceiver());
                }
            }
        }
        return receiver;
    }

    public HashSet<User> getAllUsersHashList() {

        HashSet<User> allUsersHashList = new HashSet<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User (
                        (resultSet.getInt(1)),
                        (resultSet.getString(2)),
                        (resultSet.getString(3)),
                        (resultSet.getString(4)),
                        (resultSet.getString(5)),
                        (resultSet.getInt(6)),
                        (resultSet.getDouble(7)),
                        (resultSet.getDouble(8)));
                allUsersHashList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsersHashList;
    }

    public boolean changeUserRole(int newUserRole, int userForChangeId) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE_BY_ID);
            preparedStatement.setInt(1, newUserRole);
            preparedStatement.setInt(2, userForChangeId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


