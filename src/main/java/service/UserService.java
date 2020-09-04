package service;

import dao.UserStorage;
import entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class UserService {

    UserStorage userStorage = new UserStorage();
    Writer writer = new Writer();
    Reader reader = new Reader();
    User user = new User();

    public void authUser (String login, String pass) {
        boolean auth = false;
        if (userStorage.checkUserByLogin(login) && userStorage.checkUserPassword(pass))
            auth = true;
    }

    public void addUser (String name, String lastName, String login, String pass, int  role, double balance, double salary, double income) {
        userStorage.addUser(name, lastName, login, pass, role, balance, salary, income);
        if (userStorage.checkUserByName(name)) writer.writer("User " + name + " " + lastName + " added");
    }

    public void removeUser (String login) {
        userStorage.removeUserByLogin(login);
        if (!userStorage.checkUserByLogin(login)) writer.writer("User " + login + " removed");
    }
}
