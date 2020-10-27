package dao;

import entity.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MenuDao {

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "learn2000_";

    private final static String GET_MAIN_MENU = "SELECT * FROM mainmenu";
    private final static String GET_MAIN_MENU_WITH_AUTH = "SELECT * FROM mainmenuwithauth";
    private final static String GET_ADMIN_MENU = "SELECT * FROM adminmenu";
    private final static String GET_USER_MENU = "SELECT * FROM usermenu";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection connection = null;

    public List<Menu> getMainMenu() {
        List<Menu> mainMenu = new ArrayList<>();
        String menuItemLink;
        String menuItemRus;
        int menuItemId;
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAIN_MENU);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menuItemId = resultSet.getInt(1);
                menuItemLink = resultSet.getString(2);
                menuItemRus = resultSet.getString(3);
                Menu menuItem = new Menu(menuItemId, menuItemLink, menuItemRus);
                mainMenu.add(menuItem);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainMenu;
    }

    public List<Menu> getMainMenuWithAuth() {
        List<Menu> mainMenuWithAuth = new ArrayList<>();
        String menuItemLink;
        String menuItemRus;
        int menuItemId;
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAIN_MENU_WITH_AUTH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menuItemId = resultSet.getInt(1);
                menuItemLink = resultSet.getString(2);
                menuItemRus = resultSet.getString(3);
                Menu menuItem = new Menu(menuItemId, menuItemLink, menuItemRus);
                mainMenuWithAuth.add(menuItem);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainMenuWithAuth;
    }

    public List<Menu> getAdminMenu () {
        List<Menu> adminMenu = new ArrayList<>();
        String menuItemLink;
        String menuItemRus;
        int menuItemId;
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADMIN_MENU);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menuItemId = resultSet.getInt(1);
                menuItemLink = resultSet.getString(2);
                menuItemRus = resultSet.getString(3);
                Menu menuItem = new Menu(menuItemId, menuItemLink,menuItemRus);
                adminMenu.add(menuItem);
                sortMenuById(adminMenu);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return adminMenu;
    }

    public List<Menu> getUserMenu () {
        List<Menu> userMenu = new ArrayList<>();
        String menuItemLink;
        String menuItemRus;
        int menuItemId;
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_MENU);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menuItemId = resultSet.getInt(1);
                menuItemLink = resultSet.getString(2);
                menuItemRus = resultSet.getString(3);
                Menu menuItem = new Menu(menuItemId, menuItemLink,menuItemRus);
                userMenu.add(menuItem);
                sortMenuById(userMenu);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userMenu;
    }

    protected void sortMenuById (List<Menu> menuList) {
//        List<Menu> sortedMenuList = new ArrayList<>();
        menuList.sort(Menu::compareTo);
//        sortedMenuList.addAll(menuList);
//        return sortedMenuList;
    }

}