package com.example.restaurant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bill extends BaseModel {
    @ManyToOne
    private Order order;
}
//1       1
//bill   order
//m          1