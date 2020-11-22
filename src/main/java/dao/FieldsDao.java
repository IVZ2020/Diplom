package dao;

import entity.Fields;
import entity.MenuItem;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FieldsDao extends AbstractDao {

    private final static String GET_ADMIN_FIELDS = "SELECT * FROM adminfields";
    private final static String INSERT_ADMINFIELDS_FIELDLINK = "INSERT INTO adminifields VALUE fieldlink = ?";
    private final static String INSERT_ADMINFIELDS_FIELDRUS = "INSERT INTO adminfields VALUE fieldrus = ?";
    private final static String DELETE_ALL_FROM_ADMINFIELDS_TABLE = "DELETE FROM adminfields";

    UserDao userDao = new UserDao();

//    public void deleteAllFromAdminFieldsTable () {
//        try {
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_FROM_ADMINFIELDS_TABLE);
//            preparedStatement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public List<Fields> createListOf

//    protected void insertFieldrusInAdminFieldsTable (String currentUserLogin) {
//        List<String> adminProfileFieldsWithRusNames = userDao.getUserProfileFieldsValues(currentUserLogin);
//        try {
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMINFIELDS_FIELDRUS);
//            for (String field : adminProfileFieldsWithRusNames) {
//                preparedStatement.setString(1, field);
//                preparedStatement.executeQuery();
//            }
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    protected void insertFieldlinkToTableAdminFields (String currentUserLogin) {
//        List<String> adminProfileFieldsWithLink = userDao.getUserProfileFieldList(currentUserLogin);
//        try {
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMINFIELDS_FIELDLINK);
//            for (String field : adminProfileFieldsWithLink) {
//                preparedStatement.setString(1, field);
//                preparedStatement.executeQuery();
//            }
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public List<Fields> getAdminFieldsForEditAdminProfilePage (String currentUserLogin) {
//        List<String> userFieldList = userDao.getUserFieldList(currentUserLogin);
//        List<String> userFieldsValue = userDao.getUserFieldsValue(currentUserLogin);
//        insertFieldlinkToTableAdminFields(currentUserLogin);
//        insertFieldrusInAdminFieldsTable(currentUserLogin);
//        List<Fields> adminFieldListForEditAdminProfilePage = new ArrayList<>();
//        int fieldItemId;
//        String fieldItemLink;
//        String fieldItemRus;
//        try {
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADMIN_FIELDS);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                fieldItemId = resultSet.getInt(1);
//                fieldItemLink = resultSet.getString(2);
//                fieldItemRus = resultSet.getString(3);
//                Fields fieldsList = new Fields(fieldItemId, fieldItemLink, fieldItemRus);
//                adminFieldListForEditAdminProfilePage.add(fieldsList);
//                sortFieldsById(adminFieldListForEditAdminProfilePage);
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return adminFieldListForEditAdminProfilePage;
//    }
//
//    protected void sortFieldsById (List<Fields> menuList) {
//        menuList.sort(Fields::compareTo);
//    }

//    protected void addFieldsToTableAdminFields (String admin) {
//        List<String> adminProfileFields = userDao.getUserProfileFieldList(admin);
//        List<String> adminProfileFieldsValues = userDao.getUserProfileFieldsValues(admin);
//        try {
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADMINFIELDS_FIELDLINK);
//            for (String field : adminProfileFields) {
//                preparedStatement.setString(1, field);
//            }
//            connection.close();
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATE_ADMINFIELDS_FIELDRUS);
//            for (String field : adminProfileFieldsValues) {
//                preparedStatement.setString(1, field);
//            }
//            connection.close();
//    } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }







}