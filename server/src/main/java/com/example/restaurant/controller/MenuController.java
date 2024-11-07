package com.example.restaurant.controller;

import com.example.restaurant.model.Item;
import com.example.restaurant.model.SubItem;
import com.example.restaurant.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {

     private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    //===================Item==================
    //create the items
    @PostMapping("/item")
    public Item createItem(@RequestBody Item item) {
        return null;
    }


    //read Only one item
    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable("id") int itemid) {
        return null;
    }
    //read All item
    @GetMapping("/item")
    public List<Item> getAllItem()
    {
        return null;
    }
    //update by id item
    @PutMapping("/item/{id}")
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
    @PostMapping("/item/subitem")
    public SubItem createSubItem(@RequestBody Item item) {
        return null;
    }

    //read Only one subitem
    @GetMapping("/item/subitem/{id}")
    public SubItem getSubItemById(@PathVariable("id") int subitemid) {
        return null;
    }
    //read All subitem
    @GetMapping("/item/subitem")
    public List<SubItem> getAllSubItem()
    {
        return null;
    }

    //update by id subitem
    @PutMapping("/item/subitem/{id}")
    public Item updateSubItem(@PathVariable("id") int subitemid,  @RequestBody Item updateItem) {
        return null;
    }

    //delete by id subitem
    @DeleteMapping("/item/subitem/{id}")
    public SubItem deleteSubItem(@PathVariable("id") int subitemid) {
        return null;
    }


    @GetMapping("/")
    public String getTest(){
        return "Connect to server";
    }
}
