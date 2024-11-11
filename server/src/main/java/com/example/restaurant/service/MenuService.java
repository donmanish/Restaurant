package com.example.restaurant.service;

import com.example.restaurant.exception.MenuException;
import com.example.restaurant.model.Item;
import com.example.restaurant.model.Menu;
import com.example.restaurant.model.SubItem;

import java.util.List;

public interface MenuService {
    Menu createMenu(Menu menu) throws MenuException;
    List<Menu> getAllMenuItems();

    Item createItem(Item item) throws MenuException;
    Item getItem(int itemid);
    List<Item> getAllItems();
    Item updateItem(int itemid, Item item);
    Item deleteItem(int itemid);

    SubItem createSubItem(SubItem subItem);
    SubItem getSubItem(int subitemid);
    List<SubItem> getAllSubItems();
    SubItem updateSubItem(int subitemid, SubItem subItem);
    SubItem deleteSubItem(int subitemid);
}
