package com.example.restaurant.service;

import com.example.restaurant.exception.RestaurentException;
import com.example.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantService {
  Restaurant createRestaurent(Restaurant restaurant) throws RestaurentException;
  Restaurant getRestaurent(int restaurentid) throws RestaurentException;
  List<Restaurant> getAllRestaurant();
  Restaurant updateRestaurent(int restaurentid, Restaurant restaurant) throws RestaurentException;
  Restaurant deleteRestaurent(int restaurentid) throws RestaurentException;
}
