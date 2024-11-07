package com.example.restaurant.repositry;

import com.example.restaurant.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositry extends  JpaRepository<Item,Integer> {
}
