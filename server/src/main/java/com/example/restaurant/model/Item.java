package com.example.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "Items")
@Getter
@Setter
public class Item extends BaseModel{
    private String title;
    @ManyToOne
    private SubItem  subItems;
    @Enumerated
    private ItemType itemType;
}
