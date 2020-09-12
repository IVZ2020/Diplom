package service;

import dao.UserDao;
import entity.Menu;
import entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class UserService {

    UserDao userDao = new UserDao();

    public boolean authUser (String login, String pass) {
        if (userDao.checkUserByLogin(login) && userDao.checkUserPassword(pass))
            return true;
        return false;
    }

    public void addUser (String name, String lastName, String login, String pass, int  role, double balance, double salary, double income) {
        userDao.addUser(name, lastName, login, pass, role, balance, salary, income);
        if (userDao.checkUserByName(name)) log.info("User " + name + " " + lastName + " added");
    }

    public void registerNewUser (User user) {
            userDao.regNewUser(user);
    }

    public void removeUserByLogin (String login) {
        userDao.removeUserByLogin(login);
        if (!userDao.checkUserByLogin(login)) log.info("User " + login + " removed");
    }

    public User getUserByLogin (String login) {
        if (userDao.checkUserByLogin(login)) {
            User user = userDao.getUserByLogin(login);
            return user;
        }
            return null;
    }
}
