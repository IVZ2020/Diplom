package dao;

import entity.MoneyEvent;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoneyDao extends AbstractDao {

    final static String ADD_MONEY_EVENT = "INSERT INTO moneyhistory VALUES (DEFAULT, ?, ?, ?, ?, ?)";
    final static String UPDATE_USER_BALANCE = "UPDATE users SET balance = ? WHERE id = ?";
    final static String UPDATE_USER_DEBT = "UPDATE users SET debt = ? WHERE id = ?";

    UserDao userDao = new UserDao();

    public void addMoneyEvent (MoneyEvent moneyEvent) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_MONEY_EVENT);
            preparedStatement.setString(1, parseDateToString(date));
            preparedStatement.setDouble(2, moneyEvent.getSumm());
            preparedStatement.setString(3, moneyEvent.getCathegory());
            preparedStatement.setInt(4, moneyEvent.getIdUser());
            preparedStatement.setString(5, moneyEvent.getType());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserBalanceById(int id, double balance) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BALANCE);
            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserDebtById(int id, double debt) {
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DEBT);
            preparedStatement.setDouble(1, debt);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

