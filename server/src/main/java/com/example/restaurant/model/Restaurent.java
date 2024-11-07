package com.example.restaurant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Restaurent extends BaseModel{
    private String name;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String image;
    @ManyToOne
    private Table tables;
    @Enumerated
    private RestaurantStatus restaurantStatus;
    @ManyToOne
    private Menu menu;

    @Override
    public String toString() {
        return this.toString();
    }
}
