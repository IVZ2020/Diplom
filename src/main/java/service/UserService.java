package service;

import dao.UserDao;
import entity.Fields;
import entity.User;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class UserService {

    UserDao userDao = new UserDao();

    public boolean isLoginExist(String login) {
        return userDao.isLoginExistInBase(login);
    }

    public void registerNewUser(User user) {
        userDao.regNewUser(user);
    }

    public User getUserByLogin(String login) {
        User user = userDao.getUserByLogin(login);
        return user;
    }

    public User getUserById(int id) {
        User user = userDao.getUserById(id);
        return user;
    }

    public void removeUserByLogin(String login) {
        userDao.removeUserByLogin(login);
    }

    public boolean ifUserHasFieldsNull(String login) {
        return userDao.ifUserHasFieldsNull(login);
    }

    public List<String> getUserFieldList(String login) {
        return userDao.getUserFieldList(login);
    }

    public List<String> getUserFieldsValue(String login) {
        return userDao.getUserFieldsValue(login);
    }

    public List<String> getUserProfileFieldsValues(String login) {return userDao.getUserProfileFieldsValues(login);}

//    public boolean isNameOrLastNameEmpty(String login) {
//        return userDao.isNameOrLastNameEmpty(login);
//    }

    public boolean changeUserName(String newName, int id) {
        return userDao.changeUserName(newName, id);
    }

    public boolean changeUserLastName (String newLastName, int id) {
        return userDao.changeUserLastName(newLastName, id);
    }

    public List<String> getUserFieldLinksForEditProfile (String tableName) {
        return userDao.getUserFieldLinksForEditProfile(tableName);
    }

    public List<String> getUserFieldRusNamesForEditProfile (String tableName) {
        return userDao.getUserFieldRusNamesForEditProfile(tableName);
    }

    public boolean changeUserPassword(String newPassword, int currentUserId) {
        return userDao.changeUserPassword(newPassword,currentUserId);
    }

    public boolean changeUserSalary(double newSalary, int currentUserId) {
        return userDao.changeUserSalary(newSalary, currentUserId);
    }

    public boolean changeUserIncome(double newIncome, int currentUserId) {
        return userDao.changeUserIncome(newIncome, currentUserId);
    }

    public List<User> getAllUsers () {
        return userDao.getAllUsers();
    }

    public void removeUserById(int userForDeleteId) {
        userDao.removeUserById(userForDeleteId);
    }
}


//        log.info("Admin " + user.getName() + " " + user.getName() + " added");