package com.example.restaurant.repositry;

import com.example.restaurant.model.SubItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubItemRepositry extends JpaRepository<SubItem, Long> {
}
