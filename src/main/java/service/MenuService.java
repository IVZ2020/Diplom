package service;

import dao.MenuDao;
import entity.Menu;
import entity.MenuItem;

import java.util.List;

public class MenuService {

    MenuDao menuDao = new MenuDao();

    public List<MenuItem> getMainMenu() {
        return menuDao.getMainMenu();
    }

    public List<MenuItem> getMainMenuWithAuth(int role) {
        return menuDao.getMainMenuWithAuth(role);
    }


    public List<MenuItem> getAdminMenu() {
        return menuDao.getAdminMenu();
    }

    public List<MenuItem> getUserMenu() {
        return menuDao.getUserMenu();
    }

    public Menu getMainMenuArray () {
        return menuDao.getMainMenuArray();
    }
}
