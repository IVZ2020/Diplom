package dao;

import entity.Menu;
import entity.MenuItem;
import entity.MenuItem;
//import sun.rmi.server.InactiveGroupException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDao extends AbstractDao {

    private final static String GET_MAIN_MENU = "SELECT * FROM mainmenu";
    private final static String GET_MAIN_MENU_WITH_AUTH = "SELECT * FROM mainmenuwithauth";
    private final static String GET_ADMIN_MENU = "SELECT * FROM adminmenu";
    private final static String GET_USER_MENU = "SELECT * FROM usermenu";

    public Menu getMainMenuArray() {
        List<Integer> id = new ArrayList<>();
        List<String> menuLink = new ArrayList<>();
        List<String> menuRus = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAIN_MENU);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id.add(resultSet.getInt(1));
                menuLink.add(resultSet.getString(2));
                menuRus.add(resultSet.getString(3));
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        menu.setMenuId(id);
        menu.setMenuLink(menuLink);
        menu.setMenuRus(menuRus);
        return null;
    }

    public List<MenuItem> getMainMenu() {
        List<MenuItem> mainMenu = new ArrayList<>();
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
                MenuItem menuItem = new MenuItem(menuItemId, menuItemLink, menuItemRus);
                mainMenu.add(menuItem);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mainMenu;
    }

//    public List<MenuItem> getMainMenuWithAuth() {
//        List<MenuItem> mainMenu = new ArrayList<>();
//        String menuItemLink;
//        String menuItemRus;
//        int menuItemId;
//        try {
//            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
//            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAIN_MENU);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                menuItemId = resultSet.getInt(1);
//                menuItemLink = resultSet.getString(2);
//                menuItemRus = resultSet.getString(3);
//                MenuItem menuItem = new MenuItem(menuItemId, menuItemLink, menuItemRus);
//                mainMenu.add(menuItem);
//                connection.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return mainMenu;
//    }


    public List<MenuItem> getMainMenuWithAuth(int userRole) {
        List<MenuItem> mainMenuWithAuth = new ArrayList<>();
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
                MenuItem menuItem = new MenuItem(menuItemLink, menuItemRus);
                mainMenuWithAuth.add(menuItem);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        List<MenuItem> menu = removeMenuElement(mainMenuWithAuth, userRole);

        return removeMenuElement(mainMenuWithAuth, userRole);
    }


    public List<MenuItem> removeMenuElement (List<MenuItem> list, int role) {
        String condition1 = "userCabinet";
        String condition2 = "adminCabinet";
        String condition3 = "moderatorCabinet";

        switch (role) {
            case 1:
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i).getMenuLink().equals(condition2) || list.get(i).getMenuLink().equals(condition3)) {
                        list.remove(i);
                    }
                }
                break;
            case 2:
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i).getMenuLink().equals(condition1) || list.get(i).getMenuLink().equals(condition3)) {
                        list.remove(i);
                    }
                }
                break;
            case 3:
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i).getMenuLink().equals(condition1) || list.get(i).getMenuLink().equals(condition2)) {
                        list.remove(i);
                    }
                }
                break;
            default: return list;
        }
        return list;
    }

    public List<MenuItem> getAdminMenu () {
        List<MenuItem> adminMenu = new ArrayList<>();
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
                MenuItem menuItem = new MenuItem(menuItemId, menuItemLink,menuItemRus);
                adminMenu.add(menuItem);
                sortMenuById(adminMenu);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return adminMenu;
    }

    public List<MenuItem> getUserMenu () {
        List<MenuItem> userMenu = new ArrayList<>();
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
                MenuItem menuItem = new MenuItem(menuItemId, menuItemLink,menuItemRus);
                userMenu.add(menuItem);
                sortMenuById(userMenu);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userMenu;
    }

    protected void sortMenuById (List<MenuItem> menuList) {
//        List<Menu> sortedMenuList = new ArrayList<>();
        menuList.sort(MenuItem::compareTo);
//        sortedMenuList.addAll(menuList);
//        return sortedMenuList;
    }

}