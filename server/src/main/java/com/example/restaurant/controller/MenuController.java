package com.example.restaurant.controller;

import com.example.restaurant.dto.ItemResponseData;
import com.example.restaurant.dto.MenuItemResponseDto;
import com.example.restaurant.dto.SubItemResponseData;
import com.example.restaurant.exception.ItemException;
import com.example.restaurant.exception.MenuException;
import com.example.restaurant.exception.SubItemException;
import com.example.restaurant.model.Item;
import com.example.restaurant.model.Menu;
import com.example.restaurant.model.SubItem;
import com.example.restaurant.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    //create the items
    @PostMapping("/menu")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu menus = menuService.createMenu(menu);
        MenuItemResponseDto responseDto = new MenuItemResponseDto();
        if (menus == null) {
            responseDto.setStatus(HttpStatus.BAD_REQUEST);
            responseDto.setMessage("Invalid menu");
            throw new MenuException(responseDto.getStatus(), responseDto.getMessage());
        }
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successfully created menu");
        return new ResponseEntity<>(menus, responseDto.getStatus());
    }
    //create the items
    @GetMapping("/menu")
    public ResponseEntity<MenuItemResponseDto> getAllMenuItems() {

            List<Menu> listItem = menuService.getAllMenuItems();
            MenuItemResponseDto responseDto = new MenuItemResponseDto();
            responseDto.setMenu(listItem);
            if( listItem == null ){
                responseDto.setStatus(HttpStatus.BAD_REQUEST);
                responseDto.setMessage("No items found or null.");
            } else {
                responseDto.setStatus(HttpStatus.OK);
                responseDto.setMessage("All items found.");
            }

            return new ResponseEntity<>(responseDto, responseDto.getStatus());

    }


    //===================Item===============================================================

    //create the item
    @PostMapping("/menu/item")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item items = menuService.createItem(item);
        ItemResponseData responseDto = new ItemResponseData();
        if (items == null) {
            responseDto.setStatus(HttpStatus.BAD_REQUEST);
            responseDto.setMessage("Invalid menu");
            throw new MenuException(responseDto.getStatus(), responseDto.getMessage());
        }
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successfully created menu");
        return new ResponseEntity<>(items, responseDto.getStatus());
    }
    //read Only one item
    @GetMapping("/menu/item/{id}")
    public Item getItemById(@PathVariable("id") int itemid) {
        return null;
    }
    //read All item
    @GetMapping("/menu/item")
    public ResponseEntity<ItemResponseData> getAllItem()
    {
        List<Item> listItem = menuService.getAllItems();
        ItemResponseData responseDto = new ItemResponseData();
        if(listItem.isEmpty()){
            responseDto.setItem(listItem);
            responseDto.setStatus(HttpStatus.BAD_REQUEST);
            responseDto.setMessage("Item may not found or empty.");
        } else {
            responseDto.setItem(listItem);
            responseDto.setStatus(HttpStatus.OK);
            responseDto.setMessage("All items found.");
        }
        return new ResponseEntity<>(responseDto, responseDto. getStatus());
    }
    //update by id item
    @PutMapping("/menu/item/{id}")
    public Item updateItem(@PathVariable("id") int itemid,  @RequestBody Item updateItem) {
        return null;
    }

    //delete by id item
    @DeleteMapping("/item/{id}")
    public Item deleteItem(@PathVariable("id") int itemid) {
        return null;
    }

//======================================sub item============================================

    //create the subitem
    @PostMapping("/menu/item/subitem")
    public ResponseEntity<SubItem> createSubItem(@RequestBody SubItem subItem) {
        SubItem subItems = menuService.createSubItem(subItem);
        SubItemResponseData responseDto = new SubItemResponseData();
        if (subItems == null) {
            responseDto.setStatus(HttpStatus.BAD_REQUEST);
            responseDto.setMessage("Invalid menu");
            throw new SubItemException(responseDto.getStatus(), responseDto.getMessage());
        }
        responseDto.setStatus(HttpStatus.OK);
        responseDto.setMessage("Successfully created menu");
        return new ResponseEntity<>(subItems, responseDto.getStatus());
    }

    //read Only one subitem
    @GetMapping("/menu/item/subitem/{id}")
    public SubItem getSubItemById(@PathVariable("id") int subitemid) {
        return null;
    }
    //read All subitem
    @GetMapping("/menu/item/subitem")
    public ResponseEntity<SubItemResponseData> getAllSubItem()
    {
        List<SubItem> listItem = menuService.getAllSubItems();
        SubItemResponseData responseDto = new SubItemResponseData();
        if(listItem.isEmpty()){
            responseDto.setSubitem(listItem);
            responseDto.setStatus(HttpStatus.BAD_REQUEST);
            responseDto.setMessage("Item may not found or empty.");
        } else {
            responseDto.setSubitem(listItem);
            responseDto.setStatus(HttpStatus.OK);
            responseDto.setMessage("All sub items found.");
        }
        return new ResponseEntity<>(responseDto, responseDto. getStatus());
    }

    //update by id subitem
    @PutMapping("/menu/item/subitem/{id}")
    public Item updateSubItem(@PathVariable("id") int subitemid,  @RequestBody Item updateItem) {
        return null;
    }

    //delete by id subitem
    @DeleteMapping("/menu/item/subitem/{id}")
    public SubItem deleteSubItem(@PathVariable("id") int subitemid) {
        return null;
    }


    @GetMapping("/")
    public String getTest(){
        return "Connect to server";
    }
}
