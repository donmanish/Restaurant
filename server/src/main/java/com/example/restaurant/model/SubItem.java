package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JsonBackReference
    private Item item;
}
