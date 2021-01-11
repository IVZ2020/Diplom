package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class User {

    private int id;
    private String name;
    private String lastName;
    private String login;
    private String pass;
    private int role;
    private double balance;
    private double debt;
    private boolean changeBalance;
//    private List<Action> history; // Как поместить в базу историю пользователя?

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public User(String name, String lastName, String login, String pass, int role) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }

    public User(int id, String name, String lastName, String login, String pass, int role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.pass = pass;
        this.role = role;
    }
}
