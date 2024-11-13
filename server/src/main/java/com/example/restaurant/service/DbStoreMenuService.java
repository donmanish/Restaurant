package com.example.restaurant.service;


import com.example.restaurant.exception.MenuException;
import com.example.restaurant.exception.SubItemException;
import com.example.restaurant.model.Item;
import com.example.restaurant.model.Menu;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.model.SubItem;
import com.example.restaurant.repositry.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("DbStoreMenuService")
public class DbStoreMenuService implements MenuService{
    private final ItemRepositry itemRepositry;
    private final SubItemRepositry subItemRepositry;
    private final UserRepositry userRepositry;
    private final MenuRepositry menuRepositry;
    private final RestaurantRepositry restaurantRepositry;
    private final RestaurantService restaurantService;

    public DbStoreMenuService(ItemRepositry itemRepositry, SubItemRepositry subItemRepositry, UserRepositry userRepositry, MenuRepositry menuRepositry, RestaurantRepositry restaurantRepositry, RestaurantService restaurantService) {
        this.itemRepositry = itemRepositry;
        this.subItemRepositry = subItemRepositry;
        this.userRepositry = userRepositry;
        this.menuRepositry = menuRepositry;
        this.restaurantRepositry = restaurantRepositry;
        this.restaurantService = restaurantService;
    }

    @Override
    public Menu createMenu(Menu menu) throws MenuException {
        Menu savedMenu = new Menu();
        //to many change of item so list of item
        if(menu.getItem().size() == 0){
            throw new MenuException(HttpStatus.BAD_REQUEST, "item not found");
        }
        List<Item> items = new ArrayList<>();
        for(Item it : menu.getItem())
        {
            Optional<Item> optionalItem = itemRepositry.findByTitle(it.getTitle());
            if (optionalItem.isPresent())
            {
                items.add(it);
            } else{
                throw new MenuException(HttpStatus.BAD_REQUEST, "Item not present");
            }
            optionalItem.get().setMenu(savedMenu);
            items.add(optionalItem.get());
        }

        savedMenu.setItem(items);
        savedMenu.setUsers(menu.getUsers());
        try {

            Optional<Restaurant> optionalRestaurent = restaurantRepositry.findByEmail(menu.getRestaurant().getEmail());
            if (!optionalRestaurent.isPresent()) {
                throw new MenuException(HttpStatus.NOT_FOUND, "Restaurant not found");
            }


            savedMenu.setRestaurant(optionalRestaurent.get());


        } catch (MenuException e) {
            e.printStackTrace();
            throw new MenuException(HttpStatus.BAD_REQUEST, "Menu not found");
        }


        savedMenu = menuRepositry.save(savedMenu);
        return savedMenu;
    }

    @Override
    public Menu getAllMenuItemsFromRestaurantName(String email)  throws MenuException {
        Menu menus = new Menu();
        Optional<Restaurant> optionalRestaurant = restaurantRepositry.findByEmail(email);
        System.out.println(optionalRestaurant.isPresent());
        if(!optionalRestaurant.isPresent()){
            throw new MenuException(HttpStatus.NOT_FOUND, "Restaurant not found");
        }
        if(menus.getRestaurant() != optionalRestaurant.get())
        {
            throw new MenuException(HttpStatus.BAD_REQUEST, "Restaurant name does not match");
        }else {
            menus = optionalRestaurant.get().getMenu();
        }
        return menus;
    }

    @Override
    public List<Menu> getAllMenuItems() {
       List<Menu> menuList = menuRepositry.findAll();
       return  menuList;
    }

    @Override
    public Item createItem(Item item) throws MenuException {
        // Initialize a new Item entity
        Item savedItem = new Item();
        savedItem.setTitle(item.getTitle());
        savedItem.setItemType(item.getItemType());
        // Save the Item along with its associated SubItems
        itemRepositry.save(savedItem);
        return savedItem;
    }


    @Override
    public Item getItem(int itemid) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
       List<Item> items = itemRepositry.findAll();
       return items;
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
        SubItem saveSubItem = new SubItem();
        saveSubItem.setName(subItem.getName());
        saveSubItem.setPrice(subItem.getPrice());
        saveSubItem.setImage(subItem.getImage());
        saveSubItem.setDescription(subItem.getDescription());
        try {
            Optional<Item> Otionalitems = itemRepositry.findByTitle(subItem.getItem().getTitle());
            if(Otionalitems == null){
                   throw new MenuException(HttpStatus.BAD_REQUEST, "item not found");
            } else {
                subItem.setItem(Otionalitems.get());
            }
            saveSubItem = subItemRepositry.save(subItem);
        } catch (SubItemException e)
        {
              e.printStackTrace();
              throw new SubItemException(HttpStatus.BAD_REQUEST, "Item not found");
        }

        return saveSubItem;
    }


    @Override
    public SubItem getSubItem(int subitemid) {
        return null;
    }

    @Override
    public List<SubItem> getAllSubItems() {
        List<SubItem> subItemsList = subItemRepositry.findAll().stream().collect(Collectors.toList());
        return subItemsList;
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
