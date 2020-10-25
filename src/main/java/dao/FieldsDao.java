package dao;

import entity.Fields;
import entity.Menu;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FieldsDao {

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "learn2000_";

    private final static String GET_ADMIN_FIELDS = "SELECT * FROM adminfields";
    private final static String UPDATE_ADMINFIELDS_FIELDLINK = "UPDATE fieldlink FROM adminfields WHERE fieldlink = ?";
    private final static String UPDATE_ADMINFIELDS_FIELDRUS = "UPDATE fieldrus FROM adminfields WHERE fieldrus = ?";
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection connection = null;

    public List<Fields> getAdminFields () {
        addFieldsToTableAdminFields("admin");
        List<Fields> adminFieldList = new ArrayList<>();
        int fieldItemId;
        String fieldItemLink;
        String fieldItemRus;
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADMIN_FIELDS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                fieldItemId = resultSet.getInt(1);
                fieldItemLink = resultSet.getString(2);
                fieldItemRus = resultSet.getString(3);
                Fields fieldsList = new Fields(fieldItemId, fieldItemLink, fieldItemRus);
                adminFieldList.add(fieldsList);
                sortFieldsById(adminFieldList);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return adminFieldList;
    }

    protected List<Fields> sortFieldsById (List<Fields> fieldsList) {
        List<Fields> sortedFieldList = new ArrayList<>();
        fieldsList.sort(Fields::compareTo);
        sortedFieldList.addAll(fieldsList);
        return sortedFieldList;
    }

    protected void addFieldsToTableAdminFields (String admin) {
        UserDao userDao = new UserDao();
        List<String> adminProfileFields = userDao.getUserProfileFieldList(admin);
        List<String> adminProfileFieldsValues = userDao.getUserProfileFieldsValues(admin);
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMINFIELDS_FIELDLINK);
            for (String field : adminProfileFields) {
                preparedStatement.setString(1, field);
            }
            connection.close();
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATE_ADMINFIELDS_FIELDRUS);
            for (String field : adminProfileFieldsValues) {
                preparedStatement.setString(1, field);
            }
            connection.close();
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}