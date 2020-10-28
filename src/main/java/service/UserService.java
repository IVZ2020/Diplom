package service;

import dao.UserDao;
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

    public boolean isNameOrLastNameEmpty(String login) {
        return userDao.isNameOrLastNameEmpty(login);
    }

    public boolean changeUserName(String newName, String password, int id) {
        return userDao.changeUserName(newName, password, id);
    }

    public boolean changeUserLastName (String newLastName, String password, int id) {
        return userDao.changeUserLastName(newLastName, password, id);
    }
}


//        log.info("Admin " + user.getName() + " " + user.getName() + " added");