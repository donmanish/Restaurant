package com.example.restaurant.controller;

import com.example.restaurant.model.Item;
import com.example.restaurant.model.Restaurent;
import com.example.restaurant.model.SubItem;
import com.example.restaurant.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class RestaurentControler {

    private RestaurantService restaurantService;

    public RestaurentControler(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //create the resturant
    @PostMapping("/restaurant")
    public Restaurent createRestaurant(@RequestBody Restaurent restaurant) {
//        try {
//            Restaurent restaurent = restaurantService.createRestaurent(restaurant);
//        } catch (e)
//        {
//
//        }
       return null;
    }


    //read Only one resturant
    @GetMapping("/restaurant/{id}")
    public Restaurent getRestaurantById(@PathVariable("id") int restaurantid) {
        return null;
    }
    //read All resturant
    @GetMapping("/restaurant")
    public List<Restaurent> getAllRestaurant()
    {
        return null;
    }
    //update by id resturant
    @PutMapping("/restaurant/{id}")
    public Restaurent updateRestaurant(@PathVariable("id") int restaurantid,  @RequestBody Restaurent updaterestaurant) {
     return null;
    }

    //delete by id resturant
    @DeleteMapping("/restaurant/{id}")
    public Restaurent deleteRestaurant(@PathVariable("id") int restaurantid) {
        return null;
    }




}
