package com.example.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
public class Order extends BaseModel{
    private String name;

    @ManyToOne
    private Restaurant restaurent;

    @OneToMany(mappedBy = "order" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("item")
    private List<Item>  items;

    private double totalPrice;

    @Enumerated
    private OrderStatus orderStatus;
}
