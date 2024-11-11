package com.example.restaurant.repositry;

import com.example.restaurant.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepositry extends JpaRepository<Menu, Integer> {

    Optional<Menu> findByRestaurantEmail(String email);
}
