package com.example.restaurant.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "items")
@Getter
@Setter
public class Item extends BaseModel{
    private String title;
    @Enumerated
    private ItemType itemType;

    @OneToMany(mappedBy = "item" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("sub_item")
    private List<SubItem>  subItems;

    @ManyToOne
    @JsonBackReference
    private Menu menu;

}
