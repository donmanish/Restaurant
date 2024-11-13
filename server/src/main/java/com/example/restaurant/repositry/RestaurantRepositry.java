package com.example.restaurant.repositry;

import com.example.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  RestaurantRepositry extends JpaRepository<Restaurant, Integer> {

    Optional<Restaurant> findByEmail(String name);

}
