package service;

import dao.UserDao;
import entity.Menu;
import entity.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Log4j
public class UserService {

    UserDao userDao = new UserDao();

    public boolean isLoginExist(String login) {
        if (userDao.isLoginExistInBase(login)) return true;
        else return false;
    }

    public void registerNewUser(User user) {
        userDao.regNewUser(user);
    }

    public User getUserByLogin(String login) {
        User user = userDao.getUserByLogin(login);
        if (user != null)
            return userDao.getUserByLogin(login);
        else return null;
    }

    public void removeUserByLogin(String login) {
        userDao.removeUserByLogin(login);
    }

    public boolean ifUserHasFieldsNull(String login) {
        if (userDao.ifUserHasFieldsNull(login)) return true;
        else return false;
    }

    public List<String> getUserFieldList (String login) {
        return userDao.getUserFieldList (login);
    }

    public List<String> getUserFieldsValue (String login) {
        return userDao.getUserFieldsValue(login);
    }

    public boolean isNameOrLastNameEmpty (String login) {
        return userDao.isNameOrLastNameEmpty(login);
    }
}

//        log.info("Admin " + user.getName() + " " + user.getName() + " added");