package service;

import dao.MenuDao;
import entity.Menu;

import java.util.List;

public class MenuService {

    MenuDao menuDao = new MenuDao();

    public List<Menu> getMenuItems () {
        List<Menu> menuItems = menuDao.makeMenuItems();
        return menuItems;
    }

    public List<Menu> getMenuItemsWithAuth() {
        List<Menu> menuItemsWithAuth = menuDao.makeMenuItemsWithAuth();
        return menuItemsWithAuth;
    }
}
