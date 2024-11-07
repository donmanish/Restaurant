package com.example.restaurant.service;

import com.example.restaurant.model.Item;
import com.example.restaurant.model.Restaurent;
import com.example.restaurant.model.SubItem;

import java.util.List;

public interface RestaurantService {
  Restaurent createRestaurent(Restaurent restaurant);
  Restaurent getRestaurent(int restaurentid);
  List<Restaurent> getAllRestaurant();
  Restaurent updateRestaurent(int restaurentid, Restaurent restaurant);
  Restaurent deleteRestaurent(int restaurentid);



}
