package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Restaurant extends BaseModel{
    private String name;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String image;
    private int totalTables;
    @ManyToOne
    private Table tables;
    @Enumerated
    private RestaurantStatus restaurantStatus;

    @OneToOne
    @JoinColumn(name = "menu")
    private Menu menu;

    @Override
    public String toString() {
        return this.toString();
    }
}
