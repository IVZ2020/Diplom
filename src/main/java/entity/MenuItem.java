package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem implements Comparable<MenuItem> {

    private int menuId;
    private String menuLink;
    private String menuRus;

    public MenuItem (String menuLink, String menuRus) {
        this.menuLink = menuLink;
        this.menuRus = menuRus;
    }

    @Override
    public int compareTo (MenuItem menuItem) {
        return this.menuId - menuItem.getMenuId();
    }


}
