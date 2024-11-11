package com.example.restaurant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "orders")
@Getter
@Setter
public class Order extends BaseModel{
    private String name;
    @ManyToOne
    private Restaurant restaurent;
    @ManyToOne
    private Item  items;
    private double totalPrice;
    @Enumerated
    private OrderStatus orderStatus;
}
