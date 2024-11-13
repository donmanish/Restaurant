package com.example.restaurant.service;

import com.example.restaurant.exception.RestaurentException;
import com.example.restaurant.model.Menu;
import com.example.restaurant.model.Restaurant;
import com.example.restaurant.repositry.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("DbStoreRestaurantService")
public class DbStoreRestaurantService implements RestaurantService{

    private final RestaurantRepositry restaurantRepositry;
    private final ItemRepositry itemRepositry;
    private final SubItemRepositry subItemRepositry;
    private final UserRepositry userRepositry;
    private final MenuRepositry menuRepositry;

    public DbStoreRestaurantService(RestaurantRepositry restaurantRepositry, ItemRepositry itemRepositry, SubItemRepositry subItemRepositry, UserRepositry userRepositry, MenuRepositry menuRepositry) {
        this.restaurantRepositry = restaurantRepositry;
        this.itemRepositry = itemRepositry;
        this.subItemRepositry = subItemRepositry;
        this.userRepositry = userRepositry;
        this.menuRepositry = menuRepositry;
    }

    @Override
    public Restaurant createRestaurent(Restaurant restaurant) throws RestaurentException {

        if (restaurant == null) {
            throw new RestaurentException(HttpStatus.BAD_REQUEST, "Restaurant details cannot be null.");
        }

        try {
            Restaurant savedRestaurant = new Restaurant();

            savedRestaurant.setName(restaurant.getName());
            savedRestaurant.setAddress(restaurant.getAddress());
            savedRestaurant.setPhone(restaurant.getPhone());
            savedRestaurant.setEmail(restaurant.getEmail());
            savedRestaurant.setDescription(restaurant.getDescription());
            savedRestaurant.setTotalTables(restaurant.getTotalTables());
            savedRestaurant.setRestaurantStatus(restaurant.getRestaurantStatus());
            savedRestaurant.setImage(restaurant.getImage());
            restaurantRepositry.save(savedRestaurant);
            return savedRestaurant;
        } catch (RestaurentException e) {
            throw new RestaurentException(e.getStatus(), e.getMessage());
        }


    }

    @Override
    public Restaurant getRestaurent(int restaurentid) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {

        try {
            List<Restaurant> restaurants = restaurantRepositry.findAll().stream()
                    .filter(restaurant -> restaurant.getName() != null)  // Example filter
                    .collect(Collectors.toList());
            return restaurants;

        }catch (RestaurentException e){
            throw new RestaurentException(e.getStatus(), "Failed to get all restaurant details.");
        }

    }

    @Override
    public Restaurant updateRestaurent(int restaurentid, Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant deleteRestaurent(int restaurentid) {
        return null;
    }

}
