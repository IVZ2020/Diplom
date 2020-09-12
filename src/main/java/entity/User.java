package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class User {

    private long id;
    private String name;
    private String lastName;
    private String login;
    private String pass;
    private int role;
    private double balance;
    private double salary;
    private double income;
    private List<Action> history; // Как поместить в базу историю пользователя?

    public User(long id, String name, String lastName, String login, String pass, int role, double balance, double salary, double income) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.pass = pass;
        this.role = role;
        this.balance = balance;
        this.salary = salary;
        this.income = income;
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public User(String name, String lastName, String login, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.pass = pass;
    }
}
