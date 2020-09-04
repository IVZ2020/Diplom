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



}
