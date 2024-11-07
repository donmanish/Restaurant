package com.example.restaurant.service;

import com.example.restaurant.model.Item;
import com.example.restaurant.model.SubItem;
import com.example.restaurant.repositry.ItemRepositry;
import com.example.restaurant.repositry.RestaurantRepositry;
import com.example.restaurant.repositry.SubItemRepositry;
import com.example.restaurant.repositry.UserRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DbStoreMenuService")
public class DbStoreMenuService implements MenuService{
    private RestaurantRepositry restaurantRepositry;
    private ItemRepositry itemRepositry;
    private SubItemRepositry subItemRepositry;
    private UserRepositry userRepositry;

    public DbStoreMenuService(RestaurantRepositry restaurantRepositry, ItemRepositry itemRepositry, SubItemRepositry subItemRepositry, UserRepositry userRepositry) {
        this.restaurantRepositry = restaurantRepositry;
        this.itemRepositry = itemRepositry;
        this.subItemRepositry = subItemRepositry;
        this.userRepositry = userRepositry;
    }

    @Override
    public Item createItem(Item item) {
        return null;
    }

    @Override
    public Item getItem(int itemid) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return List.of();
    }

    @Override
    public Item updateItem(int itemid, Item item) {
        return null;
    }

    @Override
    public Item deleteItem(int itemid) {
        return null;
    }

    @Override
    public SubItem createSubItem(SubItem subItem) {
        return null;
    }

    @Override
    public SubItem getSubItem(int subitemid) {
        return null;
    }

    @Override
    public List<SubItem> getAllSubItems() {
        return List.of();
    }

    @Override
    public SubItem updateSubItem(int subitemid, SubItem subItem) {
        return null;
    }

    @Override
    public SubItem deleteSubItem(int subitemid) {
        return null;
    }
}
