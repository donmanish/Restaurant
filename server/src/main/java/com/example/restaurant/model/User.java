package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "users")
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String phone;
    private String address;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_restaurant",
            joinColumns = @JoinColumn(name = "user"),
            inverseJoinColumns = @JoinColumn(name = "restaurant")
    )
    private List<Restaurant> restaurants = new ArrayList<>();
    @Enumerated
    private UserType userType;
}
