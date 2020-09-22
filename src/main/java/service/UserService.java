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

    public boolean authUser(String login, String pass) {
        if (userDao.checkUserByLogin(login) && userDao.checkUserPassword(pass))
            return true;
        return false;
    }

    public void addUser(String name, String lastName, String login, String pass, int role, double balance, double salary, double income) {
        userDao.addUser(name, lastName, login, pass, role, balance, salary, income);
        if (userDao.checkUserByName(name)) log.info("User " + name + " " + lastName + " added");
    }

    public void registerNewAdmin(User user) {
        userDao.regNewAdmin(user);
    }

    public boolean checkUserLogin (String login) {
        if (userDao.checkUserByLogin(login)) {
            return true;
        }
        return false;
    }

    public boolean checkAdminLogin (String login) {
        if (userDao.checkAdminByLogin(login)) return true;
        return false;
    }

    public void registerNewUser(User user) {
        userDao.regNewUser(user);
    }

    public User getUserByLogin(String login) {
        if (userDao.checkUserByLogin(login)) {
            User user = userDao.getUserByLogin(login);
            return user;
        }
        return null;
    }

    public User getAdminByLogin (String login) {
        if (userDao.checkAdminByLogin(login)) {
            User admin = userDao.getAdminByLogin(login);
            return admin;
        }
        return null;
    }

    public void removeUserByLogin(String login) {
        userDao.removeUserByLogin(login);
//        if (!userDao.checkUserByLogin(login)) log.info("User " + login + " removed");
    }

    public String getMessage (String message) {
        String currentMessage = userDao.getMessage(message);
        return currentMessage;
    }

    public boolean checkLogin (String login) {
        if (userDao.getLogin(login)) return true;
        return false;
        }
    public boolean checkPassword (String password) {
        if (userDao.getPassword(password)) return true;
        return false;
        }

}


//        log.info("Admin " + user.getName() + " " + user.getName() + " added");