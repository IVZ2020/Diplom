package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Comparable<Menu> {

    private int menuId;
    private String menuLink;
    private String menuRus;

    public Menu(String menuLink, String menuRus) {
        this.menuLink = menuLink;
        this.menuRus = menuRus;
    }

    @Override
    public int compareTo (Menu menuItem) {
        return this.menuId - menuItem.getMenuId();
    }
}
