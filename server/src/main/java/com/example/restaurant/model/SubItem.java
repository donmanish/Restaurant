package com.example.restaurant.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SubItem extends BaseModel {
    private String name;
    private int price;
    private int quantity;
    private String description;
    private String image;
}
