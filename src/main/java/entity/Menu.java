package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    private int menuId;
    private String menuLink;
    private String menuRus;

    public Menu(String menuLink, String menuRus) {
        this.menuLink = menuLink;
        this.menuRus = menuRus;
    }
}
