package dao;

import entity.MoneyEvent;

import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoneyDao extends AbstractDao {

    final static String ADD_MONEY_EVENT = "INSERT INTO moneyhistory VALUES (DEFAULT, ?, ?, ?, ?, ?)";
    final static String UPDATE_USER_BALANCE = "UPDATE users SET balance = ? WHERE id = ?";
    final static String UPDATE_USER_DEBT = "UPDATE users SET debt = ? WHERE id = ?";
    final static String  GET_ALL_MONEY_EVENTS_BY_ID = "SELECT * FROM moneyhistory WHERE id = ?";

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

    public List<MoneyEvent> getAllUserMoneyEventById(int id) {
        List<MoneyEvent> moneyEvents = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MONEY_EVENTS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                moneyEvents.add(new MoneyEvent(resultSet.getInt(1),parseStringToDate(resultSet.getString(2)), resultSet.getDouble(3),
                        resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return moneyEvents;
    }
}

