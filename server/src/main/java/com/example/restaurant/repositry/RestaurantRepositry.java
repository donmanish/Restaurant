package com.example.restaurant.repositry;

import com.example.restaurant.model.Restaurent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RestaurantRepositry extends JpaRepository<Restaurent, Integer> {

}
