package com.example.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Menu extends BaseModel{
    @ManyToOne
    private Item item;
    @ManyToOne
    private User users;
}
