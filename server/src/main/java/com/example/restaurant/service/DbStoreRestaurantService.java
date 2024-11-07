package com.example.restaurant.service;

import com.example.restaurant.model.Restaurent;
import com.example.restaurant.repositry.ItemRepositry;
import com.example.restaurant.repositry.RestaurantRepositry;
import com.example.restaurant.repositry.SubItemRepositry;
import com.example.restaurant.repositry.UserRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DbStoreRestaurantService")
public class DbStoreRestaurantService implements RestaurantService{

    private RestaurantRepositry restaurantRepositry;
    private ItemRepositry itemRepositry;
    private SubItemRepositry subItemRepositry;
    private UserRepositry userRepositry;

    public DbStoreRestaurantService(RestaurantRepositry restaurantRepositry, ItemRepositry itemRepositry, SubItemRepositry subItemRepositry, UserRepositry userRepositry) {
        this.restaurantRepositry = restaurantRepositry;
        this.itemRepositry = itemRepositry;
        this.subItemRepositry = subItemRepositry;
        this.userRepositry = userRepositry;
    }

    @Override
    public Restaurent createRestaurent(Restaurent restaurant) {
        return null;
    }

    @Override
    public Restaurent getRestaurent(int restaurentid) {
        return null;
    }

    @Override
    public List<Restaurent> getAllRestaurant() {
        return List.of();
    }

    @Override
    public Restaurent updateRestaurent(int restaurentid, Restaurent restaurant) {
        return null;
    }

    @Override
    public Restaurent deleteRestaurent(int restaurentid) {
        return null;
    }

}
