package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Menu {
    private List<Integer> menuId;
    private List<String> menuLink;
    private List<String> menuRus;
}