package service;

import dao.UserStorage;
import entity.User;

public class UserService {

    UserStorage userStorage = new UserStorage();
    Writer writer = new Writer();
    Reader reader = new Reader();
    User user = new User();

    public boolean authUser (String login, String pass) {
        if (userStorage.checkUserByLogin(login) && userStorage.checkUserPassword(pass))
            return true;
        return false;
    }

    public void addUser (String name, String lastName, String login, String pass, int  role, double balance, double salary, double income) {
        userStorage.addUser(name, lastName, login, pass, role, balance, salary, income);
        if (userStorage.checkUserByName(name)) writer.writer("User " + name + " " + lastName + " added");
    }

    public void removeUserByLogin (String login) {
        userStorage.removeUserByLogin(login);
        if (!userStorage.checkUserByLogin(login)) writer.writer("User " + login + " removed");
    }

    public User getUserByLogin (String login) {
        if (userStorage.checkUserByLogin(login)) {
            User user = userStorage.getUserByLogin(login);
            return user;
        }
            return null;
    }
}
