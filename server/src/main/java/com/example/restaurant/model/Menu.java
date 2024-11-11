package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Menu extends BaseModel{

    @OneToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("item")
    private List<Item> item;

    @OneToMany
    private List<User> users;
}
