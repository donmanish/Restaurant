package com.example.restaurant.repositry;

import com.example.restaurant.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepositry extends  JpaRepository<Item, Integer> {
     Optional<Item> findByTitle(String title);
}
