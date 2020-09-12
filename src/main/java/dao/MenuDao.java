package dao;

import entity.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDao {

    Connection connection = null;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
    private final static String LOGIN_TABLES = "postgres";
    private final static String PASS_TABLES = "learn2000_";

    private final static String GET_MENU_ITEMS = "select * from menuitems";

    public List<Menu> makeMenuItems () {
        List<Menu> menuItems = new ArrayList<>();
        String menuItemLink;
        String menuItemRus;
        int menuItemId;
        try {
            connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MENU_ITEMS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menuItemId = resultSet.getInt(1);
                menuItemLink = resultSet.getString(2);
                menuItemRus = resultSet.getString(3);

                Menu menuItem = new Menu(menuItemId, menuItemLink, menuItemRus);
                menuItems.add(menuItem);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuItems;
    }
}
