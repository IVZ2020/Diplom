package service;

import dao.MenuDao;
import entity.Menu;

import java.util.List;

public class MenuService {

    MenuDao menuDao = new MenuDao();

    public List<Menu> getMainMenu() {
        return menuDao.getMainMenu();
    }

    public List<Menu> getMainMenuWithAuth() {
        return menuDao.getMainMenuWithAuth();
    }


    public List<Menu> getAdminMenu() {
        return menuDao.getAdminMenu();
    }

    public List<Menu> getUserMenu() {
        return menuDao.getUserMenu();
    }
}
