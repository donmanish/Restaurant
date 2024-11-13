package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


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

    @OneToMany
    private List<Table> tables;

    @Enumerated
    private RestaurantStatus restaurantStatus;

    @OneToOne
    @JoinColumn(name = "menu")
    @JsonIgnore
    private Menu menu;

    @ManyToMany(mappedBy = "restaurants")
    private List<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return this.toString();
    }
}
