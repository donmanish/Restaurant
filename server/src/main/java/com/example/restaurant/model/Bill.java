package com.example.restaurant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bill extends BaseModel {
    @ManyToOne
    private Order order;

    @OneToOne
    private Payment payment;
}
//1       1
//bill   order
//m          1